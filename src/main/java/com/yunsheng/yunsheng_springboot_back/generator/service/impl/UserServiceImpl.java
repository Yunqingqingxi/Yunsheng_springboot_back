package com.yunsheng.yunsheng_springboot_back.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunsheng.yunsheng_springboot_back.generator.domain.User;
import com.yunsheng.yunsheng_springboot_back.generator.service.UserService;
import com.yunsheng.yunsheng_springboot_back.generator.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 花见
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-06-26 13:46:30
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




