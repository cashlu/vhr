package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Joblevel;
import cn.com.tobetop.vhr.service.JoblevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Joblevel)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("joblevel")
public class JoblevelController {
    /**
     * 服务对象
     */
    @Resource
    private JoblevelService joblevelService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Joblevel selectOne(Integer id) {
        return this.joblevelService.queryById(id);
    }

}