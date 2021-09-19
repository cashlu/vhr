package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Salary;
import cn.com.tobetop.vhr.service.SalaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Salary)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("salary")
public class SalaryController {
    /**
     * 服务对象
     */
    @Resource
    private SalaryService salaryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Salary selectOne(Integer id) {
        return this.salaryService.queryById(id);
    }

}