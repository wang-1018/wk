package com.ln.service;

import com.ln.pojo.City;
import com.ln.pojo.User;
import com.ln.utils.PageResult;

import java.util.List;

/**
 * @author 王宽
 * @date 2020/6/6
 */
public interface UserService {
    List<User> findAll();

    PageResult findPage(int page, int rows);

    int add(User user);

    void update(User user);

    User findOne(Long id);

    int delete(Long[] ids);

    List<City> findByParentId(Long pid);
}
