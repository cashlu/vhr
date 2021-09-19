package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Nation;
import cn.com.tobetop.vhr.service.NationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Nation)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("nation")
public class NationController {
    /**
     * 服务对象
     */
    @Resource
    private NationService nationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Nation selectOne(Integer id) {
        return this.nationService.queryById(id);
    }

}