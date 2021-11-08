package cn.com.tobetop.vhr.controller.salary;

import cn.com.tobetop.vhr.model.PageRespBean;
import cn.com.tobetop.vhr.model.RespBean;
import cn.com.tobetop.vhr.model.Salary;
import cn.com.tobetop.vhr.service.EmployeeService;
import cn.com.tobetop.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 员工账套设置Controller
 * @author: Cash
 * @create: 2021-11-08 00:20
 **/

@RestController
@RequestMapping("/salary/sobcfg/")
public class SobConfigController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public PageRespBean getPageEmployee(@RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getPageEmployeesWithSalary(page, size);
    }

    @GetMapping("/salary")
    public RespBean getAllSalaries() {
        List<Salary> salaries = salaryService.getAllSalaries();
        if (salaries == null || salaries.size() == 0) {
            return RespBean.build().setStatus(400).setMsg("获取工资账套失败！请确认是否提前添加工资账套，或联系管理员！");
        }
        return RespBean.build().setStatus(200).setObj(salaries);
    }

    @PutMapping("/")
    public RespBean updateEmployeeSalary(@RequestParam Integer eid, @RequestParam Integer sid) {
        int count = employeeService.updateSalary(eid, sid);
        if (count == 1 || count == 2) {
            return RespBean.build().setStatus(200).setMsg("修改工资账套成功！");
        }
        return RespBean.build().setStatus(400).setMsg("修改工资账套失败！");
    }

}
