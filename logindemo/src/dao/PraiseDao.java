package dao;

import entity.Praise;

public interface PraiseDao {
    /**
     *点赞增加或减少
     * @param
     * @return
     */
    void updatePraise(int blogId,int userId);

    /**
     * 插入没有的点赞记录条
     * @param
     * @return
     */
    int inserPraise(int blogId,int userId);

    int deletePraise(int blogId,int userId);
}
