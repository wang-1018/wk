package com.ln.mapper;

import com.ln.pojo.Address;

import java.util.List;

/**
 * @author 王宽
 * @date 2020/6/6
 */
public interface AddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);


    List<Address> selectAll();

    int deleteByUserId(Long id);

    Address selectByUserId(Long id);

    int addAddress(Address address);

    void updateByUser(Address addr);
}
