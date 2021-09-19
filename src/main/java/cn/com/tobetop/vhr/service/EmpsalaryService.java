package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.Empsalary;
import java.util.List;

/**
 * (Empsalary)表服务接口
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public interface EmpsalaryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Empsalary queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Empsalary> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param empsalary 实例对象
     * @return 实例对象
     */
    Empsalary insert(Empsalary empsalary);

    /**
     * 修改数据
     *
     * @param empsalary 实例对象
     * @return 实例对象
     */
    Empsalary update(Empsalary empsalary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}