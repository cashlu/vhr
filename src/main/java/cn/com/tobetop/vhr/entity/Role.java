package cn.com.tobetop.vhr.entity;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -32401789726001959L;
    
    private Integer id;
    
    private String name;
    /**
    * 角色名称
    */
    private String namezh;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamezh() {
        return namezh;
    }

    public void setNamezh(String namezh) {
        this.namezh = namezh;
    }

}