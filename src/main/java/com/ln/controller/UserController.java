package com.ln.controller;

import com.ln.pojo.City;
import com.ln.pojo.User;
import com.ln.service.UserService;
import com.ln.utils.PageResult;
import com.ln.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 王宽
 * @date 2020/6/6
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return userService.findPage(page, rows);
    }
    /**
     * 增加
     * @param user
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody User user){
        try {
            userService.add(user);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }
    /**
     * 修改
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody User user){
        try {
            userService.update(user);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            int i = userService.delete(ids);
            if(i==1){
                return new Result(true, "删除成功");
            }else {
                return new Result(false, "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }



    @RequestMapping(value = "/findByParentId")
    public List<City> findByParentId(Long pid){
        List<City> list = userService.findByParentId(pid);
        return list;
    }
}
