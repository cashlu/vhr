package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.HrRole;
import java.util.List;

/**
 * (HrRole)表服务接口
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
public interface HrRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HrRole queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HrRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param hrRole 实例对象
     * @return 实例对象
     */
    HrRole insert(HrRole hrRole);

    /**
     * 修改数据
     *
     * @param hrRole 实例对象
     * @return 实例对象
     */
    HrRole update(HrRole hrRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}