package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Student;
import generator.mapper.StudentMapper;
import generator.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author 花见
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2024-06-12 21:44:08
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

}




