package cn.com.tobetop.vhr.service.impl;

import cn.com.tobetop.vhr.entity.Adjustsalary;
import cn.com.tobetop.vhr.dao.AdjustsalaryDao;
import cn.com.tobetop.vhr.service.AdjustsalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Adjustsalary)表服务实现类
 *
 * @author makejava
 * @since 2021-09-18 04:30:48
 */
@Service("adjustsalaryService")
public class AdjustsalaryServiceImpl implements AdjustsalaryService {
    @Resource
    private AdjustsalaryDao adjustsalaryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Adjustsalary queryById(Integer id) {
        return this.adjustsalaryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Adjustsalary> queryAllByLimit(int offset, int limit) {
        return this.adjustsalaryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param adjustsalary 实例对象
     * @return 实例对象
     */
    @Override
    public Adjustsalary insert(Adjustsalary adjustsalary) {
        this.adjustsalaryDao.insert(adjustsalary);
        return adjustsalary;
    }

    /**
     * 修改数据
     *
     * @param adjustsalary 实例对象
     * @return 实例对象
     */
    @Override
    public Adjustsalary update(Adjustsalary adjustsalary) {
        this.adjustsalaryDao.update(adjustsalary);
        return this.queryById(adjustsalary.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.adjustsalaryDao.deleteById(id) > 0;
    }
}