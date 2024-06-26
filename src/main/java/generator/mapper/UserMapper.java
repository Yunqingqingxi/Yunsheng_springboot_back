package generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import generator.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 花见
 * @description 针对表【user(用户信息)】的数据库操作Mapper
 * @createDate 2024-06-26 14:24:12
 * @Entity generator.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




