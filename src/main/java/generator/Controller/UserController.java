package generator.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import generator.Common.R;
import generator.domain.Employee;
import generator.domain.VO.EmpVo;
import generator.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static generator.util.jwt.createToken;

@RestController
@Slf4j
@RequestMapping("/admin/employee")
public class UserController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<EmpVo> login(@RequestBody Employee employee) {
        String username = employee.getUsername();
        String password = employee.getPassword();
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Employee::getUsername, username);
        lambdaQueryWrapper.eq(Employee::getPassword, password);
        Employee emp = employeeService.getOne(lambdaQueryWrapper);

        if (emp != null) {
            String token = createToken(Long.valueOf(emp.getId()));
            EmpVo empVO = new EmpVo(emp.getId(), emp.getName(), token, emp.getUsername());

            return R.success(empVO);
        }
        return R.error("账号或密码错误");
    }

//    @PutMapping("/register")
//    public R<String> register(@RequestBody User user) {
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getUsername, user.getUsername());
//        User user1 = userService.getOne(lambdaQueryWrapper);
//        if (user1 != null) {
//            throw new UserExe("用户名已存在");
//        }
//
//        userService.save(user);
//        return R.success("注册成功");
//    }

}
