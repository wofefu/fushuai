package fushuai.dao;

import fushuai.entity.Anchor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AnchorDao {
    /**
     * 实名认证后注册成为主播
     * @param anchor
     */
    int insert(@Param("anchor") Anchor anchor);

    /**
     * 模糊查询搜哪一类的主播
     * @param anchorname  主播昵称
     * @param roomcode    房间号
     * @param address    房间地址
     * @param title     直播标题
     * @return   返回查到的主播列表
     */
    List<Anchor> select(@Param("anchorname") String anchorname, @Param("roomcode") Integer roomcode, @Param("address") String address, @Param("title") String title);

    /**
     * 更新直播标题和直播背景图
     * @param title
     * @param icon
     */
    void updateTitle(@Param("title") String title,@Param("icon") String icon,@Param("user_id") int uId);
}
