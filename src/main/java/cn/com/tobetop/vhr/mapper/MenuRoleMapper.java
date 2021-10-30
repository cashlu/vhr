package cn.com.tobetop.vhr.mapper;

import cn.com.tobetop.vhr.entity.MenuRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    Integer deleteByRid(Integer rid);

    Integer batchInsert(@Param("rid") Integer rid,@Param("mids") List<Integer> mids);
}