package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.Oplog;
import java.util.List;

/**
 * (Oplog)表服务接口
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public interface OplogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Oplog queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Oplog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param oplog 实例对象
     * @return 实例对象
     */
    Oplog insert(Oplog oplog);

    /**
     * 修改数据
     *
     * @param oplog 实例对象
     * @return 实例对象
     */
    Oplog update(Oplog oplog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}