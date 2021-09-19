package cn.com.tobetop.vhr.service.impl;

import cn.com.tobetop.vhr.entity.Employeetrain;
import cn.com.tobetop.vhr.dao.EmployeetrainDao;
import cn.com.tobetop.vhr.service.EmployeetrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employeetrain)表服务实现类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@Service("employeetrainService")
public class EmployeetrainServiceImpl implements EmployeetrainService {
    @Resource
    private EmployeetrainDao employeetrainDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Employeetrain queryById(Integer id) {
        return this.employeetrainDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Employeetrain> queryAllByLimit(int offset, int limit) {
        return this.employeetrainDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employeetrain 实例对象
     * @return 实例对象
     */
    @Override
    public Employeetrain insert(Employeetrain employeetrain) {
        this.employeetrainDao.insert(employeetrain);
        return employeetrain;
    }

    /**
     * 修改数据
     *
     * @param employeetrain 实例对象
     * @return 实例对象
     */
    @Override
    public Employeetrain update(Employeetrain employeetrain) {
        this.employeetrainDao.update(employeetrain);
        return this.queryById(employeetrain.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeetrainDao.deleteById(id) > 0;
    }
}