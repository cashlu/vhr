package cn.com.tobetop.vhr.service.impl;

import cn.com.tobetop.vhr.entity.HrRole;
import cn.com.tobetop.vhr.dao.HrRoleDao;
import cn.com.tobetop.vhr.service.HrRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HrRole)表服务实现类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@Service("hrRoleService")
public class HrRoleServiceImpl implements HrRoleService {
    @Resource
    private HrRoleDao hrRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HrRole queryById(Integer id) {
        return this.hrRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HrRole> queryAllByLimit(int offset, int limit) {
        return this.hrRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param hrRole 实例对象
     * @return 实例对象
     */
    @Override
    public HrRole insert(HrRole hrRole) {
        this.hrRoleDao.insert(hrRole);
        return hrRole;
    }

    /**
     * 修改数据
     *
     * @param hrRole 实例对象
     * @return 实例对象
     */
    @Override
    public HrRole update(HrRole hrRole) {
        this.hrRoleDao.update(hrRole);
        return this.queryById(hrRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.hrRoleDao.deleteById(id) > 0;
    }
}