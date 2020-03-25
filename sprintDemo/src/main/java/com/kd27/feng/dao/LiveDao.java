package com.kd27.feng.dao;


import com.kd27.feng.entity.LiveRoom;
import com.kd27.feng.entity.RequestForm;
import com.kd27.feng.entity.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface LiveDao {

//    List<LiveRoom> searchLive(@Param("anchorName") String anchorName, @Param("anchorStatus") String anchorStatus, @Param("offset") Integer offset);

    /**
     * 关键字找直播
     * @param search 关键字
     * @return
     */
    List<LiveRoom> searchLiveByKeyWord(@Param("search") Search search);

    /**
     * 找五条直播
     * @return
     */
    List<LiveRoom> select5live();

    /**
     * 修改直播间信息
     * @param liveRoom 保存直播间信息
     */
    void updateLiveInfo(@Param("l")LiveRoom liveRoom);

    /**
     * 加直播间
     * @param liveRoom
     */
    void addLive(@Param("liveRoom") LiveRoom liveRoom);

    /**
     * 主播申请表
     * @param requestForm
     */
    void addFormRequest(@Param("requestForm") RequestForm requestForm);

    /**
     * 查所有的主播申请表
     * @return
     */
    List<RequestForm> allRequestForm();
//    RequestForm searchForm(Integer formId);

    /**
     * 同意申请
     * @param requestId
     */
    void agreeRequest(@Param("id") Integer requestId);

    /**
     * 不同意
     * @param requestId
     */
    void disagreeRequest(@Param("id") Integer requestId);

    /**
     * 通过userId找直播
     * @param userId
     * @return
     */
    LiveRoom searchLiveByUserId(@Param("id")int userId);
}
