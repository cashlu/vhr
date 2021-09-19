package cn.com.tobetop.vhr.entity;

import java.io.Serializable;

/**
 * (Employeetrain)实体类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public class Employeetrain implements Serializable {
    private static final long serialVersionUID = 545158314498360458L;
    
    private Integer id;
    /**
    * 员工编号
    */
    private Integer eid;
    /**
    * 培训日期
    */
    private Object traindate;
    /**
    * 培训内容
    */
    private String traincontent;
    /**
    * 备注
    */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Object getTraindate() {
        return traindate;
    }

    public void setTraindate(Object traindate) {
        this.traindate = traindate;
    }

    public String getTraincontent() {
        return traincontent;
    }

    public void setTraincontent(String traincontent) {
        this.traincontent = traincontent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}