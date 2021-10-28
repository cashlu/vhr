package cn.com.tobetop.vhr.mapper;

import cn.com.tobetop.vhr.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PositionMapper {
    /**
     * 根据ID删除职位信息。
     *
     * @param id Position的ID。
     * @return 1代表删除成功，否则代表删除失败。
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加职位信息。
     *
     * @param record Position对象。
     * @return 1代表添加成功，否则代表失败。
     */
    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    /**
     * 更新职位，字段可选，也就是说传入的Position对象中，只需要存储需更新的属性值。
     *
     * @param record Position对象。
     * @return 收影响的行数。1代表更新成功，否则代表失败。
     */
    int updateByPrimaryKeySelective(Position record);

    /**
     * 更新职位。
     *
     * @param record Position对象。
     * @return 收影响的行数。1代表更新成功，否则代表失败。
     */
    int updateByPrimaryKey(Position record);

    /**
     * 查询所有职位信息。
     *
     * @return Position的List集合。
     */
    List<Position> getAllPositions();

}