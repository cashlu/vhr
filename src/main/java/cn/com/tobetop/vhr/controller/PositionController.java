package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Position;
import cn.com.tobetop.vhr.service.PositionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Position)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("position")
public class PositionController {
    /**
     * 服务对象
     */
    @Resource
    private PositionService positionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Position selectOne(Integer id) {
        return this.positionService.queryById(id);
    }

}