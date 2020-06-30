package com.ln.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ln.mapper.AddressMapper;
import com.ln.mapper.UserMapper;
import com.ln.pojo.Address;
import com.ln.pojo.City;
import com.ln.pojo.User;
import com.ln.service.UserService;
import com.ln.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @author 王宽
 * @date 2020/6/6
 */
@Service
public class UserSrtviceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 查询全部
     */
   @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> page=   (Page<User>) userMapper.selectAll();
        String zhuzhi = "";
        for (User user : page) {
            Address address = addressMapper.selectByUserId(user.getUserid());
            String city1 = "";
            String city2 = "";
            String city3 = "";
            String address1 = "";
            if(address!=null){
                if(address.getCityid1()!=null) {
                    Long cityid1 = address.getCityid1();
                    City city = userMapper.findCityByCityId(cityid1);
                    city1 = city.getCityname();
                }
                if(address.getCityid2()!=null) {
                    Long cityid2 = address.getCityid2();
                    City city = userMapper.findCityByCityId(cityid2);
                    city2 = city.getCityname();
                }
                if(address.getCityid3()!=null) {
                    Long cityid3 = address.getCityid3();
                    City city = userMapper.findCityByCityId(cityid3);
                    city3 = city.getCityname();
                }
                address1 = address.getAddress();
                zhuzhi=city1+"省"+city2+"市"+city3+"县(区)"+address1;
                user.setZhuzhi(zhuzhi);
            }
        }
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public int add(User user) {
        try {
            User user1 = new User();
            user1.setUsername(user.getUsername());
            user1.setAge(user.getAge());
            userMapper.insert(user1);
            user.getAddr().setUserid(user1.getUserid());
            addressMapper.addAddress(user.getAddr());
            return 1;
        }catch (Exception e){
            e.printStackTrace();

            //手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }

    }


    /**
     * 修改
     */
    @Override
    public void update(User user){
        try {
            //先把用户信息进行修改
            userMapper.updateByPrimaryKey(user);
            //再修改地址表(先删除后增加)
            addressMapper.deleteByUserId(user.getUserid());
            user.getAddr().setUserid(user.getUserid());
            addressMapper.addAddress(user.getAddr());
        }catch (Exception e){
            e.printStackTrace();

            //手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

    }

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    @Override
    public User findOne(Long id){
        User user = userMapper.selectByPrimaryKey(id);
        Address address = addressMapper.selectByUserId(id);
        user.setAddr(address);
        return user;
    }

    /**
     * 批量删除
     */
    @Override
    @Transactional
    public int delete(Long[] ids) {
        try {
            for(Long id:ids){
                userMapper.deleteByPrimaryKey(id);
                int i = addressMapper.deleteByUserId(id);
                System.out.println(i);
            }
            return 1;
        }catch (Exception e){
            e.printStackTrace();

            //手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 0;
    }

    @Override
    public List<City> findByParentId(Long pid) {
        System.out.println(pid);
        List<City> user = userMapper.findByParentId(pid);
        return user;
    }

}
