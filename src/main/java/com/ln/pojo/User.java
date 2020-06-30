package com.ln.pojo;

/**
 * @author 王宽
 * @date 2020/6/6
 */
public class User {
    private Long userid;

    private String username;

    private Integer age;

    private Long id;

    private String zhuzhi;

    private Address addr = new Address();

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZhuzhi() {
        return zhuzhi;
    }

    public void setZhuzhi(String zhuzhi) {
        this.zhuzhi = zhuzhi;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", zhuzhi='" + zhuzhi + '\'' +
                ", addr=" + addr +
                '}';
    }
}
