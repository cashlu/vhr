package cn.com.tobetop.vhr.entity;

import java.io.Serializable;

/**
 * (Employee)实体类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 762784397448331142L;
    /**
    * 员工编号
    */
    private Integer id;
    /**
    * 员工姓名
    */
    private String name;
    /**
    * 性别
    */
    private String gender;
    /**
    * 出生日期
    */
    private Object birthday;
    /**
    * 身份证号
    */
    private String idcard;
    /**
    * 婚姻状况
    */
    private Object wedlock;
    /**
    * 民族
    */
    private Integer nationid;
    /**
    * 籍贯
    */
    private String nativeplace;
    /**
    * 政治面貌
    */
    private Integer politicid;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 电话号码
    */
    private String phone;
    /**
    * 联系地址
    */
    private String address;
    /**
    * 所属部门
    */
    private Integer departmentid;
    /**
    * 职称ID
    */
    private Integer joblevelid;
    /**
    * 职位ID
    */
    private Integer posid;
    /**
    * 聘用形式
    */
    private String engageform;
    /**
    * 最高学历
    */
    private Object tiptopdegree;
    /**
    * 所属专业
    */
    private String specialty;
    /**
    * 毕业院校
    */
    private String school;
    /**
    * 入职日期
    */
    private Object begindate;
    /**
    * 在职状态
    */
    private Object workstate;
    /**
    * 工号
    */
    private String workid;
    /**
    * 合同期限
    */
    private Object contractterm;
    /**
    * 转正日期
    */
    private Object conversiontime;
    /**
    * 离职日期
    */
    private Object notworkdate;
    /**
    * 合同起始日期
    */
    private Object begincontract;
    /**
    * 合同终止日期
    */
    private Object endcontract;
    /**
    * 工龄
    */
    private Integer workage;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Object getWedlock() {
        return wedlock;
    }

    public void setWedlock(Object wedlock) {
        this.wedlock = wedlock;
    }

    public Integer getNationid() {
        return nationid;
    }

    public void setNationid(Integer nationid) {
        this.nationid = nationid;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public Integer getPoliticid() {
        return politicid;
    }

    public void setPoliticid(Integer politicid) {
        this.politicid = politicid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getJoblevelid() {
        return joblevelid;
    }

    public void setJoblevelid(Integer joblevelid) {
        this.joblevelid = joblevelid;
    }

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public String getEngageform() {
        return engageform;
    }

    public void setEngageform(String engageform) {
        this.engageform = engageform;
    }

    public Object getTiptopdegree() {
        return tiptopdegree;
    }

    public void setTiptopdegree(Object tiptopdegree) {
        this.tiptopdegree = tiptopdegree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Object getBegindate() {
        return begindate;
    }

    public void setBegindate(Object begindate) {
        this.begindate = begindate;
    }

    public Object getWorkstate() {
        return workstate;
    }

    public void setWorkstate(Object workstate) {
        this.workstate = workstate;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public Object getContractterm() {
        return contractterm;
    }

    public void setContractterm(Object contractterm) {
        this.contractterm = contractterm;
    }

    public Object getConversiontime() {
        return conversiontime;
    }

    public void setConversiontime(Object conversiontime) {
        this.conversiontime = conversiontime;
    }

    public Object getNotworkdate() {
        return notworkdate;
    }

    public void setNotworkdate(Object notworkdate) {
        this.notworkdate = notworkdate;
    }

    public Object getBegincontract() {
        return begincontract;
    }

    public void setBegincontract(Object begincontract) {
        this.begincontract = begincontract;
    }

    public Object getEndcontract() {
        return endcontract;
    }

    public void setEndcontract(Object endcontract) {
        this.endcontract = endcontract;
    }

    public Integer getWorkage() {
        return workage;
    }

    public void setWorkage(Integer workage) {
        this.workage = workage;
    }

}