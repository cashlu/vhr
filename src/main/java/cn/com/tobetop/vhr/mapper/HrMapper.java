package cn.com.tobetop.vhr.mapper;

import cn.com.tobetop.vhr.entity.Hr;
import org.springframework.stereotype.Repository;

@Repository
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);
}