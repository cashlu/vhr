package cn.com.tobetop.vhr.controller.system.basic;

import cn.com.tobetop.vhr.model.Position;
import cn.com.tobetop.vhr.model.RespBean;
import cn.com.tobetop.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Program: vhr
 * @Description: 职位管理的Controller
 * @Author: Cash
 * @Create: 2021-10-27 22:45
 **/
@RestController
// 请求地址的前缀部分，要和数据库menu表中的一致。
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;


    /**
     * 获取所有职位列表。
     *
     * @return RespBean对象，其中封装列表对象，或者错误信息。
     */
    @GetMapping("/")
    public RespBean getAllPositions() {
        if (positionService.getAllPositions().size() > 0) {
            return RespBean.ok(null, positionService.getAllPositions());
        }
        return RespBean.error("获取职位列表失败");
    }

    /**
     * 添加职位信息。
     *
     * @param position 职位信息对象。
     * @return RespBean对象。
     */
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return RespBean.ok("职位添加成功");
        }
        return RespBean.error("职位添加失败");
    }


    /**
     * 更新职位信息。
     *
     * @param position Position对象，前端传来的是JSON格式的数据。
     * @return 如果更新成功，返回RespBean.ok(),否则返回RespBean.error()
     */
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updatePosition(position) == 1) {
            return RespBean.ok("职位更新成功");
        }
        return RespBean.error("职位更新失败");
    }

    /**
     * 根据ID删除职位信息。
     *
     * @param id 职位信息的ID
     * @return 删除成功返回RespBean.ok(), 否则返回RespBean.error()。
     */
    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id) {
        if (positionService.deletePositionById(id) == 1) {
            return RespBean.ok("职位删除成功");
        }
        return RespBean.error("职位删除失败");
    }

    /**
     * 根据ID列表删除职位信息。
     *
     * @param ids 职位信息的ID列表
     * @return 删除成功返回RespBean.ok(), 否则返回RespBean.error()。
     */
    @DeleteMapping("/")
    public RespBean batchDeletePositionByIds(@RequestBody List<Integer> ids) {
        if (positionService.batchDeletePositionByIds(ids) == ids.size()) {
            return RespBean.ok("批量删除职位成功！");
        }
        return RespBean.error("批量删除职位失败！");
    }
}
