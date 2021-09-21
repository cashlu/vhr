package cn.com.tobetop.vhr.mapper;

import cn.com.tobetop.vhr.entity.MailSendLog;

public interface MailSendLogMapper {
    int insert(MailSendLog record);

    int insertSelective(MailSendLog record);
}