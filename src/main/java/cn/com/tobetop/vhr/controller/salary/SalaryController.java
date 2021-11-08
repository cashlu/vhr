package cn.com.tobetop.vhr.controller.salary;

import cn.com.tobetop.vhr.model.RespBean;
import cn.com.tobetop.vhr.model.Salary;
import cn.com.tobetop.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 工资账套管理的Controller
 * @author: Cash
 * @create: 2021-11-07 03:09
 **/
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespBean getAllSalaries(){
        List<Salary> salaries = salaryService.getAllSalaries();
        if (salaries.size() == 0) {
            return RespBean.build().setStatus(200).setMsg("账套数据为空，是否已创建过数据？");
        }
        return RespBean.build().setStatus(200).setObj(salaries);
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            return RespBean.build().setStatus(200).setMsg("添加工资套账成功！");
        }
        return RespBean.build().setStatus(400).setMsg("添加工资套账失败，请联系管理员");
    }

    @DeleteMapping("/")
    public RespBean deleteSalaryById(@RequestParam Integer id) {
        if (salaryService.deleteSalaryById(id) == 1){
            return RespBean.build().setStatus(200).setMsg("删除账套成功！");
        }
        return RespBean.build().setStatus(400).setMsg("删除账套失败，请联系管理员！");
    }

    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary) {
        if (salaryService.updateSalary(salary) == 1) {
            return RespBean.build().setStatus(200).setMsg("更新工资账套成功！");
        }
        return RespBean.build().setStatus(400).setMsg("更新工资账套失败，请联系管理员！");
    }
}
