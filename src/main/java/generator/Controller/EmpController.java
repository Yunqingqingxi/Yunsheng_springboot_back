package generator.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import generator.Common.PageCode;
import generator.Common.R;
import generator.Exception.UserExe;
import generator.domain.Dto.EmpDto;
import generator.domain.Employee;
import generator.domain.VO.EmpVo;
import generator.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
        Page<Employee> info = new Page<>(page, pageSize);
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name != null, Employee::getName, name);
        lambdaQueryWrapper.orderByDesc(Employee::getUpdateTime);
        Page<Employee> pageInfo = employeeService.page(info, lambdaQueryWrapper);

        long total = pageInfo.getTotal();
        List<Employee> records = pageInfo.getRecords();

        return R.success(new PageCode(total, records));
    }

    @PutMapping("/editPassword")
    public R<String> editPassword(@RequestBody EmpDto empDto) {
        if (empDto.getOldPassword() == empDto.getNewPassword())
            throw new UserExe("新密码不能与旧密码相同");
        else {
            Employee byId = employeeService.getById(empDto.getEmpId());
            byId.setPassword(empDto.getNewPassword());
        }
        return R.success("修改密码成功");
    }

    @PostMapping("/status/{status}")
    public R<String> status(@PathVariable int status, Long id) {
        Employee employee = employeeService.getById(id);
        employee.setStatus(status);
        employeeService.updateById(employee);
        return R.success("修改状态成功");
    }

    @PostMapping()
    public R<String> add(@RequestBody Employee employee) {
        employee.setPassword("123456");
        employee.setCreateTime(new Date());
        employee.setUpdateTime(new Date());
        employee.setName("员工");
        employee.setIdNumber("14888791541");
        // 默认是1 启用状态
        employee.setStatus(1);

        employeeService.save(employee);
        return R.success("添加成功");
    }

    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        return R.success(employee);
    }

    @PutMapping()
    public R<String> edit(@RequestBody Employee employee) {
        employeeService.updateById(employee);
        return R.success("修改成功");
    }

    @PostMapping("/logout")
    public R<String> logout() {
        return R.success("退出成功");
    }


    @PostMapping("/register")
    public R<String> register(@RequestBody Employee employee) {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee employee1 = employeeService.getOne(lambdaQueryWrapper);
        if (employee1 == null) {
            Employee employee2 = new Employee();
            employee2.setPassword("123456");
            employee2.setName("管理员");
            employee2.setStatus(1);
            employee2.setUsername(employee.getUsername());
            employee2.setUpdateTime(new Date());

            employee2.setCreateTime(new Date());
            employee2.setUpdateTime(new Date());
            employeeService.save(employee2);
            return R.success("注册成功");

        } else {
            throw new UserExe("用户名已存在");
        }
    }

}
