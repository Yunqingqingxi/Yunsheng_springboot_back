package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.OrderDetail;
import generator.mapper.OrderDetailMapper;
import generator.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @author 花见
 * @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
 * @createDate 2024-06-26 14:24:12
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
        implements OrderDetailService {

}




