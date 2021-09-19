package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Employeeec;
import cn.com.tobetop.vhr.service.EmployeeecService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employeeec)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("employeeec")
public class EmployeeecController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeecService employeeecService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employeeec selectOne(Integer id) {
        return this.employeeecService.queryById(id);
    }

}