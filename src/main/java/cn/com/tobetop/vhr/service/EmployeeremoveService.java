package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.Employeeremove;
import java.util.List;

/**
 * (Employeeremove)表服务接口
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public interface EmployeeremoveService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employeeremove queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Employeeremove> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param employeeremove 实例对象
     * @return 实例对象
     */
    Employeeremove insert(Employeeremove employeeremove);

    /**
     * 修改数据
     *
     * @param employeeremove 实例对象
     * @return 实例对象
     */
    Employeeremove update(Employeeremove employeeremove);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}