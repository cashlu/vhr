package cn.com.tobetop.vhr.entity;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 847547418656663360L;
    
    private Integer id;
    /**
    * 部门名称
    */
    private String name;
    
    private Integer parentid;
    
    private String deppath;
    
    private Object enabled;
    
    private Object isparent;


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

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getDeppath() {
        return deppath;
    }

    public void setDeppath(String deppath) {
        this.deppath = deppath;
    }

    public Object getEnabled() {
        return enabled;
    }

    public void setEnabled(Object enabled) {
        this.enabled = enabled;
    }

    public Object getIsparent() {
        return isparent;
    }

    public void setIsparent(Object isparent) {
        this.isparent = isparent;
    }

}