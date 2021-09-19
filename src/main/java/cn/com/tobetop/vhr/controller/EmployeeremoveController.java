package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Employeeremove;
import cn.com.tobetop.vhr.service.EmployeeremoveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employeeremove)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("employeeremove")
public class EmployeeremoveController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeremoveService employeeremoveService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employeeremove selectOne(Integer id) {
        return this.employeeremoveService.queryById(id);
    }

}