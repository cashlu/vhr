package cn.com.tobetop.vhr.mapper;

import cn.com.tobetop.vhr.entity.JobLevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Cash
 */
@Mapper
public interface JobLevelMapper {
    /**
     * 根据ID删除职称信息。
     *
     * @param id 待删除的职称ID。
     * @return 删除的记录数。
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入职称记录。
     *
     * @param record JobLevel对象。
     * @return 插入的记录数。
     */
    int insert(JobLevel record);

    /**
     * 选择性的插入职称记录。参数中的JobLevel对象，其内部的属性不用全部赋值，没有值的属性，数据库中会写入空值，
     * 或者数据库表中定义的默认值。
     *
     * @param record JobLevel对象。
     * @return
     */
    int insertSelective(JobLevel record);

    /**
     * 根据ID查询职称信息。
     *
     * @param id 职称的ID
     * @return JobLevel对象。
     */
    JobLevel selectByPrimaryKey(Integer id);

    /**
     * 选择性更新职称信息。参数的JobLevel对象，内部属性只需要给需要更新的字段赋值，没有值的属性，保持原样。
     *
     * @param record JobLevel对象。
     * @return 更新的记录数。
     */
    int updateByPrimaryKeySelective(JobLevel record);

    /**
     * 更新职称信息。
     *
     * @param record 待更新的JobLevel对象。
     * @return 修改的记录数。
     */
    int updateByPrimaryKey(JobLevel record);

    /**
     * 获取所有的职称信息。
     *
     * @return 职称的List。
     */
    List<JobLevel> getAllJobLevels();

    /**
     * 根据ID的List，批量删除职称。
     *
     * @param ids ID的List列表。
     * @return 删除的行数。
     */
    Integer batchDeleteJobLevelByIds(List<Integer> ids);
}