package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.AddressBook;
import generator.mapper.AddressBookMapper;
import generator.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @author 花见
 * @description 针对表【address_book(地址簿)】的数据库操作Service实现
 * @createDate 2024-06-26 14:24:12
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
        implements AddressBookService {

}




