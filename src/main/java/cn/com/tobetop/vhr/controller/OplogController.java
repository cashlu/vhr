package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Oplog;
import cn.com.tobetop.vhr.service.OplogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Oplog)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("oplog")
public class OplogController {
    /**
     * 服务对象
     */
    @Resource
    private OplogService oplogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Oplog selectOne(Integer id) {
        return this.oplogService.queryById(id);
    }

}