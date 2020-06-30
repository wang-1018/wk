package com.ln.pojo;

/**
 * @author 王宽
 * @date 2020/6/6
 */
public class Address {
    private Long id;

    private String address;

    private Long userid;

    private Long cityid1;

    private Long cityid2;

    private Long cityid3;

    private String xiangxi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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

    public String getXiangxi() {
        return xiangxi;
    }

    public void setXiangxi(String xiangxi) {
        this.xiangxi = xiangxi;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", userid=" + userid +
                ", cityid1=" + cityid1 +
                ", cityid2=" + cityid2 +
                ", cityid3=" + cityid3 +
                ", xiangxi='" + xiangxi + '\'' +
                '}';
    }
}
