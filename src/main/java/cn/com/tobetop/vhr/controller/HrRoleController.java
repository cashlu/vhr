package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.HrRole;
import cn.com.tobetop.vhr.service.HrRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (HrRole)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("hrRole")
public class HrRoleController {
    /**
     * 服务对象
     */
    @Resource
    private HrRoleService hrRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HrRole selectOne(Integer id) {
        return this.hrRoleService.queryById(id);
    }

}