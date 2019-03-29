package com.demo.firt.service;


import com.demo.firt.model.Address;

import java.util.List;

public interface AddressService {
    //增加地址
     void add(Address address);

    //删除地址
     void delete(int id);

    //更新地址
     void update(Address address);

    //查询地址
     Address get(int id );

    //查询多个地址
     List<Address> getAllAddress();

}
