package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Employee;
import generator.mapper.EmployeeMapper;
import generator.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author 花见
 * @description 针对表【employee(员工信息)】的数据库操作Service实现
 * @createDate 2024-06-26 14:24:12
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService {

}




