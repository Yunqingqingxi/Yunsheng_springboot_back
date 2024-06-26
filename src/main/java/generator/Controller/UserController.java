package generator.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import generator.Common.R;
import generator.Exception.UserExe;
import generator.domain.User;
import generator.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static generator.util.jwt.createToken;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public R<String> login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, username);
        lambdaQueryWrapper.eq(User::getPassword, password);
        User student = userService.getOne(lambdaQueryWrapper);
        if (student != null) {
            String token = createToken(Long.valueOf(student.getId()));
            return R.success(token);
        }
        return R.error("账号或密码错误");
    }

    @PutMapping("/register")
    public R<String> register(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, user.getUsername());
        User user1 = userService.getOne(lambdaQueryWrapper);
        if (user1 != null) {
            throw new UserExe("用户名已存在");
        }

        userService.save(user);
        return R.success("注册成功");
    }

}
