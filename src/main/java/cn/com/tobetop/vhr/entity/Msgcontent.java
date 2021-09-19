package cn.com.tobetop.vhr.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Msgcontent)实体类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public class Msgcontent implements Serializable {
    private static final long serialVersionUID = 765933536959689386L;
    
    private Integer id;
    
    private String title;
    
    private String message;
    
    private Date createdate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

}