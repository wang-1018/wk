package com.ln.mapper;

import com.ln.pojo.City;
import com.ln.pojo.User;
import com.ln.utils.PageResult;

import java.util.List;

/**
 * @author 王宽
 * @date 2020/6/6
 */
public interface UserMapper {
    int deleteByPrimaryKey(Long userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();

    City findCityByCityId(Long cityid1);

    List<City> findByParentId(Long pid);
}
