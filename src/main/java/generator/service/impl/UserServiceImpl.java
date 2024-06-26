package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.User;
import generator.mapper.UserMapper;
import generator.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 花见
 * @description 针对表【user(用户信息)】的数据库操作Service实现
 * @createDate 2024-06-26 14:24:12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}




