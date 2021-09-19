package cn.com.tobetop.vhr.dao;

import cn.com.tobetop.vhr.entity.Appraise;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Appraise)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-18 04:30:49
 */
public interface AppraiseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Appraise queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Appraise> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param appraise 实例对象
     * @return 对象列表
     */
    List<Appraise> queryAll(Appraise appraise);

    /**
     * 新增数据
     *
     * @param appraise 实例对象
     * @return 影响行数
     */
    int insert(Appraise appraise);

    /**
     * 修改数据
     *
     * @param appraise 实例对象
     * @return 影响行数
     */
    int update(Appraise appraise);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}