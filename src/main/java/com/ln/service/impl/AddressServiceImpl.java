package com.ln.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ln.mapper.AddressMapper;
import com.ln.pojo.Address;
import com.ln.service.AddressService;
import com.ln.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王宽
 * @date 2020/6/6
 */
@Service
public class AddressServiceImpl implements AddressService {
@Autowired
    private AddressMapper addressMapper;

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            addressMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public Address findOne(Long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Address address) {
        addressMapper.updateByPrimaryKey(address);
    }

    @Override
    public void add(Address address) {
        addressMapper.insert(address);
    }


    @Override
    public List<Address> findAll() {
        return addressMapper.selectAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Address> page=   (Page<Address>) addressMapper.selectAll();
        return new PageResult(page.getTotal(), page.getResult());
    }
}
