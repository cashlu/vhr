package cn.com.tobetop.vhr.mapper;

import cn.com.tobetop.vhr.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenuByHrId(Integer hrId);

    /**
     * 获取所有Menu与Role的对应关系。
     *
     * @return
     */
    List<Menu> getAllMenusWithRole();

    /**
     * 获取所有Menu的树状结构。
     *
     * @return Menu的树状结构。
     */
    List<Menu> getAllMenus();

    /**
     * 通过roleId，获取该Role具备的Menu的ID列表。
     *
     * @param rid 角色ID
     * @return 权限（菜单）ID
     */
    List<Integer> getMidsByRid(Integer rid);
}