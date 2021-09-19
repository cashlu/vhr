package cn.com.tobetop.vhr.service.impl;

import cn.com.tobetop.vhr.entity.Nation;
import cn.com.tobetop.vhr.dao.NationDao;
import cn.com.tobetop.vhr.service.NationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Nation)表服务实现类
 *
 * @author makejava
 * @since 2021-09-18 04:30:50
 */
@Service("nationService")
public class NationServiceImpl implements NationService {
    @Resource
    private NationDao nationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Nation queryById(Integer id) {
        return this.nationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Nation> queryAllByLimit(int offset, int limit) {
        return this.nationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param nation 实例对象
     * @return 实例对象
     */
    @Override
    public Nation insert(Nation nation) {
        this.nationDao.insert(nation);
        return nation;
    }

    /**
     * 修改数据
     *
     * @param nation 实例对象
     * @return 实例对象
     */
    @Override
    public Nation update(Nation nation) {
        this.nationDao.update(nation);
        return this.queryById(nation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.nationDao.deleteById(id) > 0;
    }
}