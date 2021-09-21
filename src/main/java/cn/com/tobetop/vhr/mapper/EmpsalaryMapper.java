package cn.com.tobetop.vhr.mapper;

import cn.com.tobetop.vhr.entity.Empsalary;

public interface EmpsalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Empsalary record);

    int insertSelective(Empsalary record);

    Empsalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Empsalary record);

    int updateByPrimaryKey(Empsalary record);
}