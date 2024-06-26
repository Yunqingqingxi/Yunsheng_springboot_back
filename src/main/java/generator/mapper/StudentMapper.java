package generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import generator.domain.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 花见
 * @description 针对表【student】的数据库操作Mapper
 * @createDate 2024-06-12 21:44:08
 * @Entity generator.domain.Student
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}




