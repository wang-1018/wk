package com.ln.vo;

import com.ln.pojo.User;

/**
 * @author 王宽
 * @date 2020/6/6
 */
public class UserVo extends User {
    private String address;

    private Long cityid1;

    private Long cityid2;

    private Long cityid3;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCityid1() {
        return cityid1;
    }

    public void setCityid1(Long cityid1) {
        this.cityid1 = cityid1;
    }

    public Long getCityid2() {
        return cityid2;
    }

    public void setCityid2(Long cityid2) {
        this.cityid2 = cityid2;
    }

    public Long getCityid3() {
        return cityid3;
    }

    public void setCityid3(Long cityid3) {
        this.cityid3 = cityid3;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "address='" + address + '\'' +
                ", cityid1=" + cityid1 +
                ", cityid2=" + cityid2 +
                ", cityid3=" + cityid3 +
                '}';
    }
}
