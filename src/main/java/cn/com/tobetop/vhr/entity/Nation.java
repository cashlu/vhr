package cn.com.tobetop.vhr.entity;

import java.io.Serializable;

/**
 * (Nation)实体类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public class Nation implements Serializable {
    private static final long serialVersionUID = 158036116742069191L;
    
    private Integer id;
    
    private String name;


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

}