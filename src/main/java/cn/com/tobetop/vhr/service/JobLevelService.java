package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.JobLevel;
import cn.com.tobetop.vhr.mapper.JobLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Program: vhr
 * @Description: JobLevel的Service类。
 * @Author: Cash
 * @Create: 2021-10-29 03:43
 **/

@Service
public class JobLevelService {

    @Autowired
    JobLevelMapper jobLevelMapper;


    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();

    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insert(jobLevel);
    }

    public Integer updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevelById(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer batchDeleteJobLevelByIds(List<Integer> ids) {
        return jobLevelMapper.batchDeleteJobLevelByIds(ids);
    }
}
