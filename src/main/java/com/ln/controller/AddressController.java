package com.ln.controller;

import com.ln.pojo.Address;
import com.ln.service.AddressService;
import com.ln.utils.PageResult;
import com.ln.utils.Result;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 王宽
 * @date 2020/6/6
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Reference
    private AddressService addressService;

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<Address> findAll(){
        return addressService.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return addressService.findPage(page, rows);
    }

    /**
     * 增加
     * @param address
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Address address){
        try {
            addressService.add(address);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param address
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Address address){
        try {
            addressService.update(address);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public Address findOne(Long id){
        return addressService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            addressService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
