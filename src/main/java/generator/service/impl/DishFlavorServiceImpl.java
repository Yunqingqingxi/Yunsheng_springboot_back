package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.DishFlavor;
import generator.mapper.DishFlavorMapper;
import generator.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * @author 花见
 * @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
 * @createDate 2024-06-26 14:24:12
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
        implements DishFlavorService {

}




