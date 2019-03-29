package com.demo.firt.service;

import com.demo.firt.dao.AddressDao;
import com.demo.firt.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public void add(Address address) {
        addressDao.save(address);
    }

    @Override
    public void delete(int id) {
        addressDao.deleteById(id);
    }

    @Override
    public void update(Address address) {
        addressDao.saveAndFlush(address);
    }

    @Override
    public Address get(int id) {
        return addressDao.findById(id).get();
    }

    @Override
    public List<Address> getAllAddress() {
        return addressDao.findAll();
    }
}
