package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Politicsstatus;
import cn.com.tobetop.vhr.service.PoliticsstatusService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Politicsstatus)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("politicsstatus")
public class PoliticsstatusController {
    /**
     * 服务对象
     */
    @Resource
    private PoliticsstatusService politicsstatusService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Politicsstatus selectOne(Integer id) {
        return this.politicsstatusService.queryById(id);
    }

}