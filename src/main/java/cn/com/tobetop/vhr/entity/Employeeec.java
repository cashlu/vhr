package cn.com.tobetop.vhr.entity;

import java.io.Serializable;

/**
 * (Employeeec)实体类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public class Employeeec implements Serializable {
    private static final long serialVersionUID = -28214727793024779L;
    
    private Integer id;
    /**
    * 员工编号
    */
    private Integer eid;
    /**
    * 奖罚日期
    */
    private Object ecdate;
    /**
    * 奖罚原因
    */
    private String ecreason;
    /**
    * 奖罚分
    */
    private Integer ecpoint;
    /**
    * 奖罚类别，0：奖，1：罚
    */
    private Integer ectype;
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

    public Object getEcdate() {
        return ecdate;
    }

    public void setEcdate(Object ecdate) {
        this.ecdate = ecdate;
    }

    public String getEcreason() {
        return ecreason;
    }

    public void setEcreason(String ecreason) {
        this.ecreason = ecreason;
    }

    public Integer getEcpoint() {
        return ecpoint;
    }

    public void setEcpoint(Integer ecpoint) {
        this.ecpoint = ecpoint;
    }

    public Integer getEctype() {
        return ectype;
    }

    public void setEctype(Integer ectype) {
        this.ectype = ectype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}