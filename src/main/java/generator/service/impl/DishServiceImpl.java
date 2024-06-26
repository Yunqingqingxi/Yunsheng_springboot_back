package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Dish;
import generator.mapper.DishMapper;
import generator.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @author 花见
 * @description 针对表【dish(菜品)】的数据库操作Service实现
 * @createDate 2024-06-26 14:24:12
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
        implements DishService {

}




