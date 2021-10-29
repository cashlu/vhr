package cn.com.tobetop.vhr.controller.system.basic;

import cn.com.tobetop.vhr.entity.JobLevel;
import cn.com.tobetop.vhr.entity.RespBean;
import cn.com.tobetop.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: vhr
 * @Description: 职称管理的Controller
 * @Author: Cash
 * @Create: 2021-10-29 03:37
 **/

@RestController
@RequestMapping("/system/basic/jobLevel/")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;


    @GetMapping("/")
    public RespBean getAllJobLevels() {
        List<JobLevel> jobLevels = new ArrayList<>();
        jobLevels = jobLevelService.getAllJobLevels();
        if (jobLevels.size() > 0) {
            return RespBean.ok(null, jobLevels);
        }
        return RespBean.error("没有获取到职称列表。");
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加职称成功！");
        }
        return RespBean.error("添加职称失败！");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevel(jobLevel) == 1) {
            return RespBean.ok("修改职称成功！");
        }
        return RespBean.error("修改职称失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return RespBean.ok("删除职称成功！");
        }
        return RespBean.error("删除职称失败！");
    }


    @DeleteMapping("/")
    public RespBean batchDeleteJobLevelByIds(@RequestBody List<Integer> ids) {
        if (ids.size() > 0) {
            if (jobLevelService.batchDeleteJobLevelByIds(ids) == ids.size()) {
                return RespBean.ok("批量删除职称成功！");
            }
            return RespBean.error("批量删除职称失败！");
        }
        return RespBean.error("批量删除职称失败，因为没有传递ids！");
    }
}
