package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.MailSendLog;
import cn.com.tobetop.vhr.service.MailSendLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MailSendLog)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("mailSendLog")
public class MailSendLogController {
    /**
     * 服务对象
     */
    @Resource
    private MailSendLogService mailSendLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MailSendLog selectOne( id) {
        return this.mailSendLogService.queryById(id);
    }

}