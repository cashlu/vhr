package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Appraise;
import cn.com.tobetop.vhr.service.AppraiseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Appraise)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("appraise")
public class AppraiseController {
    /**
     * 服务对象
     */
    @Resource
    private AppraiseService appraiseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Appraise selectOne(Integer id) {
        return this.appraiseService.queryById(id);
    }

}