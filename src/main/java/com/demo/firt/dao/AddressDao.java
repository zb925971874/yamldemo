package com.demo.firt.dao;

import com.demo.firt.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address,Integer>{
}
