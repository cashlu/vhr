package cn.com.tobetop.vhr.entity;

import java.io.Serializable;

/**
 * (MailSendLog)实体类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public class MailSendLog implements Serializable {
    private static final long serialVersionUID = -24864777883720626L;
    
    private String msgid;
    
    private Integer empid;
    /**
    * 0发送中，1发送成功，2发送失败
    */
    private Integer status;
    
    private String routekey;
    
    private String exchange;
    /**
    * 重试次数
    */
    private Integer count;
    /**
    * 第一次重试时间
    */
    private Object trytime;
    
    private Object createtime;
    
    private Object updatetime;


    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoutekey() {
        return routekey;
    }

    public void setRoutekey(String routekey) {
        this.routekey = routekey;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getTrytime() {
        return trytime;
    }

    public void setTrytime(Object trytime) {
        this.trytime = trytime;
    }

    public Object getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Object createtime) {
        this.createtime = createtime;
    }

    public Object getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Object updatetime) {
        this.updatetime = updatetime;
    }

}