package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.entity.Menu;
import cn.com.tobetop.vhr.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Menu)表控制层
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Menu selectOne(Integer id) {
        return this.menuService.queryById(id);
    }

}