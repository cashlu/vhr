package cn.com.tobetop.vhr.service.impl;

import cn.com.tobetop.vhr.entity.MailSendLog;
import cn.com.tobetop.vhr.dao.MailSendLogDao;
import cn.com.tobetop.vhr.service.MailSendLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MailSendLog)表服务实现类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@Service("mailSendLogService")
public class MailSendLogServiceImpl implements MailSendLogService {
    @Resource
    private MailSendLogDao mailSendLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    @Override
    public MailSendLog queryById( ) {
        return this.mailSendLogDao.queryById();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MailSendLog> queryAllByLimit(int offset, int limit) {
        return this.mailSendLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mailSendLog 实例对象
     * @return 实例对象
     */
    @Override
    public MailSendLog insert(MailSendLog mailSendLog) {
        this.mailSendLogDao.insert(mailSendLog);
        return mailSendLog;
    }

    /**
     * 修改数据
     *
     * @param mailSendLog 实例对象
     * @return 实例对象
     */
    @Override
    public MailSendLog update(MailSendLog mailSendLog) {
        this.mailSendLogDao.update(mailSendLog);
        return this.queryById(mailSendLog.get());
    }

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.mailSendLogDao.deleteById() > 0;
    }
}