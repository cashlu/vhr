package cn.com.tobetop.vhr.controller.system.basic;

import cn.com.tobetop.vhr.model.Department;
import cn.com.tobetop.vhr.model.RespBean;
import cn.com.tobetop.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.com.tobetop.vhr.service.Const.*;

/**
 * @description: 部门管理的Controller
 * @author: Cash
 * @create: 2021-10-30 23:47
 **/

@RestController
@RequestMapping("/system/basic/department/")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespBean getDepartmentsTree() {
        List<Department> departmentsTree = departmentService.getDepartmentsTree();

        return RespBean.ok(null, departmentsTree);
    }

    @PostMapping("/")
    public RespBean addDepartment(@RequestBody Department department) {
        if (departmentService.addDepartment(department)) {
            return RespBean.ok("添加部门成功！");
        }
        return RespBean.error("添加部门失败！");
    }

    @DeleteMapping("/")
    public RespBean deleteDepartmentById(@RequestBody Department department) {
        Integer result = departmentService.deleteDepartment(department);
        if (result.equals(DELETE_DEPARTMENT_SUCCESS)) {
            return RespBean.ok("部门删除成功!");
        } else if (result.equals(HAS_EMPLOYEE)) {
            return RespBean.error("部门删除失败，该部门下有员工！");
        } else if (result.equals(HAS_SUB_DEPARTMENT)) {
            return RespBean.error("部门删除失败，该部门下有子部门！");
        }
        return RespBean.error("删除失败，未知错误，请联系管理员！");
    }
}
