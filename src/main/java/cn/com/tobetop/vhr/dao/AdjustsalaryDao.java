package cn.com.tobetop.vhr.dao;

import cn.com.tobetop.vhr.entity.Adjustsalary;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Adjustsalary)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-18 04:30:47
 */
public interface AdjustsalaryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Adjustsalary queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Adjustsalary> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adjustsalary 实例对象
     * @return 对象列表
     */
    List<Adjustsalary> queryAll(Adjustsalary adjustsalary);

    /**
     * 新增数据
     *
     * @param adjustsalary 实例对象
     * @return 影响行数
     */
    int insert(Adjustsalary adjustsalary);

    /**
     * 修改数据
     *
     * @param adjustsalary 实例对象
     * @return 影响行数
     */
    int update(Adjustsalary adjustsalary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}