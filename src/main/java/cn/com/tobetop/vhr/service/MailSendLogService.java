package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.MailSendLog;
import java.util.List;

/**
 * (MailSendLog)表服务接口
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public interface MailSendLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    MailSendLog queryById( );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MailSendLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mailSendLog 实例对象
     * @return 实例对象
     */
    MailSendLog insert(MailSendLog mailSendLog);

    /**
     * 修改数据
     *
     * @param mailSendLog 实例对象
     * @return 实例对象
     */
    MailSendLog update(MailSendLog mailSendLog);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    boolean deleteById( );

}