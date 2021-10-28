package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.Position;
import cn.com.tobetop.vhr.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Program: vhr
 * @Description: Position(职位)的Service
 * @Author: Cash
 * @Create: 2021-10-27 22:51
 **/

@Service
public class PositionService {

    @Autowired
    PositionMapper positionMapper;

    /**
     * 获取所有职位信息的Service。
     *
     * @return Position的List封装。
     */
    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();

    }

    /**
     * 添加职位的Service。
     *
     * @param position Position（职位）对象。
     * @return 受影响行数，添加成功应该为1, 否则为失败。
     */
    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insert(position);
    }

    /**
     * 更新职位信息。
     *
     * @param position Position对象。
     * @return 受影响的行数。通常如果更新成功，会返回1，否则代表更新失败。
     */
    public Integer updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    /**
     * 根据ID删除职位信息。
     *
     * @param id 职位的ID
     * @return 1代表删除成功，否则代表删除失败。
     */
    public Integer deletePositionById(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }
}
