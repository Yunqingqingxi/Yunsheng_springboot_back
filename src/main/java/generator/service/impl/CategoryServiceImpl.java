package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Category;
import generator.mapper.CategoryMapper;
import generator.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @author 花见
 * @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
 * @createDate 2024-06-26 14:24:12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {

}




