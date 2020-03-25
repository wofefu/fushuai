package com.kd27.feng.service;

import com.kd27.feng.entity.LiveRoom;
import com.kd27.feng.entity.RequestForm;
import com.kd27.feng.entity.Search;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface LiveRoomService {
    List<LiveRoom> searchLiveByKeyWord( Search search);
    List<LiveRoom> select5live();
    void addFormRequest(RequestForm requestForm);
    List<RequestForm> allRequestForm();
    void addLive(LiveRoom liveRoom);

    void agreeRequest(Integer requestId);
    void disagreeRequest( Integer requestId);
    LiveRoom searchLiveByUserId(int userId);

    void updateLiveInfo(LiveRoom liveRoom);
}
