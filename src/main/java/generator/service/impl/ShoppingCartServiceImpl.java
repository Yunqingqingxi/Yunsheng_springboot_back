package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.ShoppingCart;
import generator.mapper.ShoppingCartMapper;
import generator.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @author 花见
 * @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
 * @createDate 2024-06-26 14:24:12
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
        implements ShoppingCartService {

}




