package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Empsalary;
import cn.com.tobetop.vhr.service.EmpsalaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Empsalary)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("empsalary")
public class EmpsalaryController {
    /**
     * 服务对象
     */
    @Resource
    private EmpsalaryService empsalaryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Empsalary selectOne(Integer id) {
        return this.empsalaryService.queryById(id);
    }

}