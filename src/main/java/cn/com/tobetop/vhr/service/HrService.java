package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.Hr;
import java.util.List;

/**
 * (Hr)表服务接口
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public interface HrService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Hr queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Hr> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param hr 实例对象
     * @return 实例对象
     */
    Hr insert(Hr hr);

    /**
     * 修改数据
     *
     * @param hr 实例对象
     * @return 实例对象
     */
    Hr update(Hr hr);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}