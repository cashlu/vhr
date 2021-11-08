package cn.com.tobetop.vhr.controller.emp;


import cn.com.tobetop.vhr.model.*;
import cn.com.tobetop.vhr.service.*;
import cn.com.tobetop.vhr.utils.PoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


/**
 * @description: 员工基本资料管理的Controller。
 * @author: Cash
 * @create: 2021-11-02 15:10
 **/

@RestController
@RequestMapping("/employee/basic/")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    NationService nationService;

    @Autowired
    PoliticsStatusService politicsStatusService;

    @Autowired
    JobLevelService jobLevelService;

    @Autowired
    PositionService positionService;

    @Autowired
    DepartmentService departmentService;

    /**
     * 获取用户基本信息列表。（包括搜索功能）
     * 该接口既实现简单的完整列表获取，也实现简单的姓名查找以及忽略姓名的多参检索。之所以将一些参数设置为required=false，
     * 是因为在业务逻辑上，姓名简单查找时，前端不传多参检索的其他参数；同理，在多参检索时，前端不传姓名。
     *
     * @param page            分页页码
     * @param size            每页行数
     * @param name            员工姓名（用作简单查找）
     * @param politicStatusId 政治面貌ID
     * @param nationId        民族ID
     * @param positionId      职位ID
     * @param departmentId    部门ID
     * @param jobLevelId      职称ID
     * @param engageForm      聘用形式
     * @param beginDateRange  入职时间的搜索范围
     * @return 员工基本信息的列表
     */
    @GetMapping("/")
    public PageRespBean getPageEmployee(@RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) Integer politicStatusId,
                                        @RequestParam(required = false) Integer nationId,
                                        @RequestParam(required = false) Integer positionId,
                                        @RequestParam(required = false) Integer departmentId,
                                        @RequestParam(required = false) Integer jobLevelId,
                                        @RequestParam(required = false) String engageForm,
                                        // @DateTimeFormat注解，可以通过pattern参数，将字符串解析为LocalDate对象。
                                        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") List<LocalDate> beginDateRange) {
        return employeeService.getPageRespBean(page, size, name, politicStatusId, nationId, positionId,
                departmentId, jobLevelId, engageForm, beginDateRange);
    }


    @PostMapping("/")
    public RespBean addEmp(@RequestBody cn.com.tobetop.vhr.model.Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return RespBean.build().setStatus(200).setMsg("添加用户成功！");
        }
        return RespBean.build().setStatus(400).setMsg("添加用户失败！");
    }

    @GetMapping("/nations/")
    public RespBean getAllNations() {
        List<Nation> nations = nationService.getAllNations();
        if (nations.size() == 0) {
            return RespBean.error("获取民族列表失败，请确定是否提前维护好民族列表！");
        }
        return RespBean.build().setStatus(200).setObj(nations);
    }


    @GetMapping("/politics/")
    public RespBean getAllPoliticsStatus() {
        List<PoliticsStatus> politics = politicsStatusService.getAllPolitics();
        if (politics.size() == 0) {
            return RespBean.error("获取政治面貌列表失败，情确认是否提前维护好政治面貌列表！");
        }
        return RespBean.build().setStatus(200).setObj(politics);
    }

    @GetMapping("/jobLevels/")
    public RespBean getAllJobLevels() {
        List<cn.com.tobetop.vhr.model.JobLevel> jobLevels = jobLevelService.getAllJobLevels();
        if (jobLevels.size() == 0) {
            return RespBean.error("获取职称列表失败，请确认是否提前维护好职称列表！");
        }
        return RespBean.build().setStatus(200).setObj(jobLevels);
    }

    @GetMapping("/positions/")
    public RespBean getAllPositions() {
        List<Position> positions = positionService.getAllPositions();
        if (positions.size() == 0) {
            return RespBean.error("获取职位列表失败，请确认是否提前维护好职位列表！");
        }
        return RespBean.build().setStatus(200).setObj(positions);
    }

    // TODO: 目前的逻辑是，当前端打开添加员工对话框后，从后端获取数据库中最大的一个workId，然后+1，作为新员工的workId，
    //  但是这种处理方式，并不是线程安全的。应该把这个工作交给后端来完成，后端在入库的时候生成。
    @GetMapping("/maxWorkId")
    public RespBean getMaxWorkId() {
        Integer res = employeeService.getMaxWorkId() + 1;
        String maxWorkId = String.format("%08d", res);
        // TODO: 修改了RespBean类，以便支持下面这种链式调用。其他的controller可以修改为这种方式，尤其是那些不需要返回msg的。
        return RespBean.build().setStatus(200).setObj(maxWorkId);
    }

    @GetMapping("/departments")
    public RespBean getDepartments() {
        List<Department> departmentsTree = departmentService.getDepartmentsTree();
        if (departmentsTree.size() == 0) {
            return RespBean.build().setStatus(400).setMsg("获取到的部门列表为空，请确认是否有添加部门信息！");
        }
        return RespBean.build().setStatus(200).setObj(departmentsTree);
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmployeeById(@PathVariable Integer id) {
        if (employeeService.deleteEmployeeById(id) == 1) {
            return RespBean.build().setStatus(200).setMsg("删除员工成功！");
        }
        return RespBean.build().setStatus(400).setMsg("删除员工失败");
    }

    @PutMapping("/")
    public RespBean updateEmployee(@RequestBody cn.com.tobetop.vhr.model.Employee employee) {
        if (employeeService.updateEmployee(employee) == 1) {
            return RespBean.build().setStatus(200).setMsg("更新员工信息成功！");
        }
        return RespBean.build().setStatus(400).setMsg("更新员工信息失败！");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        // 没有传入page和size，所以mybatis判断时，会返回所有结果（具体在mapper的xml中有定义）。
        List<cn.com.tobetop.vhr.model.Employee> employees = (List<cn.com.tobetop.vhr.model.Employee>) employeeService.getPageRespBean(null, null, null, null, null, null, null, null, null, null).getData();
        return PoiUtils.employeeToExcel(employees);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Nation> nations = nationService.getAllNations();
        List<PoliticsStatus> politics = politicsStatusService.getAllPolitics();
        List<Department> departments = departmentService.getAllDepartments();
        List<cn.com.tobetop.vhr.model.JobLevel> jobLevels = jobLevelService.getAllJobLevels();
        List<Position> positions = positionService.getAllPositions();
        List<Employee> employees = PoiUtils.excelToEmployee(file, nations, politics, departments, positions, jobLevels);

        if (employees.size() == 0) {
            return RespBean.build().setStatus(400).setMsg("上传的excel文件为空");
        }

        if (employeeService.batchAddEmployees(employees) != employees.size()) {
            return RespBean.build().setStatus(400).setMsg("批量导入员工信息失败，请联系管理员！");
        }
        return RespBean.build().setStatus(200).setMsg("批量导入员工信息成功！");
    }
}
