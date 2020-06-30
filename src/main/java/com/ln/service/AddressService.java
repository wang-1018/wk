package com.ln.service;

import com.ln.pojo.Address;
import com.ln.utils.PageResult;

import java.util.List;

/**
 * @author 王宽
 * @date 2020/6/6
 */
public interface AddressService {
    void delete(Long[] ids);

    Address findOne(Long id);

    void update(Address address);

    void add(Address address);

    List<Address> findAll();

    PageResult findPage(int pageNum, int pageSize);
}
