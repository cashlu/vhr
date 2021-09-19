package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Department;
import cn.com.tobetop.vhr.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("department")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Department selectOne(Integer id) {
        return this.departmentService.queryById(id);
    }

}