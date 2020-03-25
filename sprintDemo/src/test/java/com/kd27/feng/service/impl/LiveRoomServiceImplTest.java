package com.kd27.feng.service.impl;

import com.kd27.feng.entity.Search;
import com.kd27.feng.service.LiveRoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class LiveRoomServiceImplTest {
    @Autowired
    LiveRoomService liveRoomService;
    @Test
    public void searchLiveByKeyWord() {
        Search search =new Search();
        search.setPageIndex(2);
        search.setPageMax(1);
        search.setSearchKeyWord("1");
        System.out.println(liveRoomService.searchLiveByKeyWord(search));
    }
}