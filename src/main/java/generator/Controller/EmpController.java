package generator.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import generator.Common.PageCode;
import generator.Common.R;
import generator.Exception.UserExe;
import generator.domain.Employee;
import generator.domain.VO.EmpVo;
import generator.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static generator.util.Jwt.createToken;

@RestController
@Slf4j
@RequestMapping("/admin/employee")
public class EmpController {
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

    @GetMapping("/page")
    public R<PageCode> page(int page, int pageSize, String name) {
        Page<Employee> info = new Page<>();
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name != null, Employee::getName, name);
        lambdaQueryWrapper.orderByDesc(Employee::getUpdateTime);
        Page<Employee> pageInfo = employeeService.page(info, lambdaQueryWrapper);

        long total = pageInfo.getTotal();
        List<Employee> records = pageInfo.getRecords();

        return R.success(new PageCode(total, records));
    }

    @PutMapping("/editPassword")
    public R<String> editPassword(@RequestBody Employee employee) {

        return R.success("修改密码成功");
    }


    @PostMapping("/register")
    public R<String> register(@RequestBody Employee employee) {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee user1 = employeeService.getOne(lambdaQueryWrapper);
        if (user1 != null) {
            throw new UserExe("用户名已存在");
        }

        employeeService.save(employee);
        return R.success("注册成功");
    }

    @DeleteMapping("/{name}")
    public R<String> delete(@PathVariable String name) {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Employee::getUsername, name);
        Employee employee = employeeService.getOne(lambdaQueryWrapper);
        if (employee != null) {
            employeeService.removeById(employee.getId());
            return R.success("删除成功");
        } else {
            return R.error(null);
        }
    }
}
