package com.demo.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.project.model.entity.AddressBook;
import com.demo.project.service.AddressBookService;
import com.demo.project.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author hzzzzzy
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2023-03-17 14:44:03
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService{

}




