package com.ln.pojo;

/**
 * @author 王宽
 * @date 2020/6/6
 */
public class City {
    private Long id;

    private Long pid;

    private String cityname;

    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", pid=" + pid +
                ", cityname='" + cityname + '\'' +
                ", type=" + type +
                '}';
    }
}
