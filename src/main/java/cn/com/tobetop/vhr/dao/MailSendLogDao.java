package cn.com.tobetop.vhr.dao;

import cn.com.tobetop.vhr.entity.MailSendLog;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (MailSendLog)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public interface MailSendLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    MailSendLog queryById( );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MailSendLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mailSendLog 实例对象
     * @return 对象列表
     */
    List<MailSendLog> queryAll(MailSendLog mailSendLog);

    /**
     * 新增数据
     *
     * @param mailSendLog 实例对象
     * @return 影响行数
     */
    int insert(MailSendLog mailSendLog);

    /**
     * 修改数据
     *
     * @param mailSendLog 实例对象
     * @return 影响行数
     */
    int update(MailSendLog mailSendLog);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 影响行数
     */
    int deleteById( );

}