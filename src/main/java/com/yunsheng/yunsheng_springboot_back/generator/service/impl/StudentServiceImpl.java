package com.yunsheng.yunsheng_springboot_back.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunsheng.yunsheng_springboot_back.generator.service.StudentService;
import com.yunsheng.yunsheng_springboot_back.generator.domain.Student;
import com.yunsheng.yunsheng_springboot_back.generator.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author 花见
* @description 针对表【student】的数据库操作Service实现
* @createDate 2024-06-26 13:46:30
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

}




