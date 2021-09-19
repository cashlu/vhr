package cn.com.tobetop.vhr.service.impl;

import cn.com.tobetop.vhr.entity.Sysmsg;
import cn.com.tobetop.vhr.dao.SysmsgDao;
import cn.com.tobetop.vhr.service.SysmsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sysmsg)表服务实现类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@Service("sysmsgService")
public class SysmsgServiceImpl implements SysmsgService {
    @Resource
    private SysmsgDao sysmsgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sysmsg queryById(Integer id) {
        return this.sysmsgDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Sysmsg> queryAllByLimit(int offset, int limit) {
        return this.sysmsgDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysmsg 实例对象
     * @return 实例对象
     */
    @Override
    public Sysmsg insert(Sysmsg sysmsg) {
        this.sysmsgDao.insert(sysmsg);
        return sysmsg;
    }

    /**
     * 修改数据
     *
     * @param sysmsg 实例对象
     * @return 实例对象
     */
    @Override
    public Sysmsg update(Sysmsg sysmsg) {
        this.sysmsgDao.update(sysmsg);
        return this.queryById(sysmsg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysmsgDao.deleteById(id) > 0;
    }
}