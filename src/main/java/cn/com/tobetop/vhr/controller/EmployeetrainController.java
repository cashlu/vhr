package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Employeetrain;
import cn.com.tobetop.vhr.service.EmployeetrainService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employeetrain)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("employeetrain")
public class EmployeetrainController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeetrainService employeetrainService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employeetrain selectOne(Integer id) {
        return this.employeetrainService.queryById(id);
    }

}