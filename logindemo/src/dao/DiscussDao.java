package dao;

import entity.Discuss;

public interface DiscussDao {
    void insert(int blogId,int userId,String content);
}
