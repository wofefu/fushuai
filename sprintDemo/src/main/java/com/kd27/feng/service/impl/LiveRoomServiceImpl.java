package com.kd27.feng.service.impl;

import com.kd27.feng.dao.LiveDao;
import com.kd27.feng.entity.LiveRoom;
import com.kd27.feng.entity.RequestForm;
import com.kd27.feng.entity.Search;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LiveRoomServiceImpl implements com.kd27.feng.service.LiveRoomService {


    private final LiveDao liveDao ;

    public LiveRoomServiceImpl(LiveDao liveDao) {
        this.liveDao = liveDao;
    }

    @Override
    public List<LiveRoom> searchLiveByKeyWord(Search search) {
        search.setSearchKeyWord("%"+search.getSearchKeyWord()+"%");
        search.setOffset((search.getPageIndex()-1)*search.getPageMax());
        return  liveDao.searchLiveByKeyWord(search);
    }

    @Override
    public List<LiveRoom> select5live() {
        return liveDao.select5live();
    }

    @Override
    public void addFormRequest(RequestForm requestForm) {
        liveDao.addFormRequest(requestForm);
    }

    @Override
    public List<RequestForm> allRequestForm() {
        return liveDao.allRequestForm();
    }

    @Override
    public void addLive(LiveRoom liveRoom) {
        liveDao.addLive(liveRoom);
    }

    @Override
    public void agreeRequest(Integer requestId) {
        liveDao.agreeRequest(requestId);
    }

    @Override
    public void disagreeRequest(Integer requestId) {
        liveDao.disagreeRequest(requestId);
    }

    @Override
    public LiveRoom searchLiveByUserId(int userId) {
        return liveDao.searchLiveByUserId(userId);
    }

    @Override
    public void updateLiveInfo(LiveRoom liveRoom) {
        liveDao.updateLiveInfo(liveRoom);
    }
}
