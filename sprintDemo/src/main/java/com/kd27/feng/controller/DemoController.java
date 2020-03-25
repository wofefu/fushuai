package com.kd27.feng.controller;


import com.kd27.feng.entity.*;
import com.kd27.feng.service.FileService;
import com.kd27.feng.service.UserService;
import com.kd27.feng.service.LiveRoomService;
import com.kd27.feng.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.*;

@Controller
public class DemoController {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
    private final VerifyService verifyService;
    private final UserService userService;
    private final LiveRoomService liveRoomService;
    private final FileService fileService;

    public DemoController(UserService userService, LiveRoomService liveRoomService, FileService fileService, VerifyService verifyService) {
        this.userService = userService;
        this.liveRoomService = liveRoomService;
        this.fileService = fileService;
        this.verifyService = verifyService;
    }

    @PostMapping(value = "/searchByKeyWord", produces = "application/JSON;charset=utf-8")
    @ResponseBody
    public List<LiveRoom> searchByKeyWord(Search search) {
        return liveRoomService.searchLiveByKeyWord(search);
    }


    @PostMapping(value = "/select5Live", produces = "application/JSON;charset=utf-8")
    @ResponseBody
    public List<LiveRoom> select5Live() {
        System.out.println(1231);
        return liveRoomService.select5live();
    }

    @PostMapping(value = "/loginVerify", produces = "application/JSON;charset=utf-8")
    @ResponseBody
    public User loginVerify(User user, HttpSession session) {
        user = userService.loginVerify(user.getUsername(), user.getPassword());
        session.setAttribute("user", user);
        return user;
    }

    @PostMapping(value = "/registerVerify", produces = "application/JSON;charset=utf-8")
    @ResponseBody
    public User registerVerify(User user, @RequestPart(value = "myicon") MultipartFile multipartFile,
                               HttpServletRequest request) {
        User userTmp = userService.selectUserByName(user.getUsername());
        try {
            if (userTmp != null) {
                return null;
            } else {
                InputStream inputStream = multipartFile.getInputStream();
                String partPath = "resources/user_resources/img/" + "default/" + simpleDateFormat.format(new Date());
                String realPath = request.getServletContext().getRealPath(partPath);
                fileService.keepFileByInputStream(inputStream, partPath, realPath);
                user.setIcon(partPath);
                userService.registerUser(user);
                if (user.getUserId() != 0) {
                    request.getSession().setAttribute("user", user);
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setPassword(null);
        return user;
    }

    @PostMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }


    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        return "index";
    }

    @GetMapping("/toLive")
    public ModelAndView toLive(String path) {
        return new ModelAndView("live", "path", path);
    }

    @PostMapping("/toInfo")
    public ModelAndView toInfo(User user) {
        return new ModelAndView("redirect:info", "user", user);
    }

    @GetMapping("/toInfo")
    public String info() {
        return "info";
    }

    @PostMapping(value = "/modifyInfo", produces = "application/JSON;charset=utf-8")
    @ResponseBody
    public User modifyInfo(@RequestPart(value = "myIcon") MultipartFile multipartFile,
                           HttpServletRequest request) {
        User user = new User();
        System.out.println("开始更新");
        System.out.println("--------------------------");
        user.setUsername(request.getParameter("username"));
        user.setGender(request.getParameter("gender"));
        user.setBirthday(request.getParameter("birthday"));
        user.setUserId(Integer.parseInt(request.getParameter("userId")));
        System.out.println(user);
        try {
            if (userService.selectUserById(user.getUserId()) != null) {
                System.out.println("用户存在开始修改");
                System.out.println("----------------------------");
                System.out.println(multipartFile.getBytes());
                InputStream inputStream = multipartFile.getInputStream();
                String partPath = "resources/user_resources/img/" + user.getUserId() + simpleDateFormat.format(new Date());
                String realPath = request.getServletContext().getRealPath(partPath);
                fileService.keepFileByInputStream(inputStream, partPath, realPath);
                user.setIcon(partPath);
                request.getSession().setAttribute("user", user);
                userService.updateUser(user);
                System.out.println(user);
                return user;
            }
            System.out.println("---------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setPassword(null);
        return user;
    }

    @PostMapping("/modifyPassword")
    @ResponseBody
    public String modifyPassword(User user) {
        System.out.println("开始更新");
        userService.updateUser(user);
        System.out.println("更新完成");
        return "1212";
    }
//    @PostMapping("/transformImg")
//    @ResponseBody
//    public String[] transformImg(@RequestPart(value = "file1")MultipartFile[] multipartFiles,HttpServletRequest request){
//        String[] strs=new String[2];
//        try {
//        for (int i=0;i<2;i++) {
//            InputStream inputStream = multipartFiles[i].getInputStream();
//            String partPath = "resources/user_resources/img/" + "default/" + simpleDateFormat.format(new Date());
//            String realPath = request.getServletContext().getRealPath(partPath);
//            fileService.keepFileByInputStream(inputStream,partPath,realPath);
//            strs[i]=fileService.getImgString(realPath);
//        }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(strs);
//        return strs;
//    }

    @PostMapping("/certification")
    @ResponseBody
    public String certification(HttpServletRequest request, @RequestPart(value = "file1") MultipartFile[] multipartFiles) {
        RequestForm form = new RequestForm();
        String name = request.getParameter("idCardName");
        String idCardNo = request.getParameter("idCardNo");
        String userId = request.getParameter("userId");
        System.out.println(userId);
        form.setUserId(Integer.parseInt(userId));
        form.setRealName(name.trim());
        form.setIdCard(idCardNo.trim());


        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy.MM.dd");
        try {

            VerifyInfo verifyInfo;
            for (int i = 0; i < 2; i++) {
                InputStream inputStream = null;
                inputStream = multipartFiles[i].getInputStream();
                String partPath = "resources/user_resources/img/" + "default/" + i + simpleDateFormat.format(new Date()) + multipartFiles[i].getOriginalFilename();
                String realPath = request.getServletContext().getRealPath(partPath);
                fileService.keepFileByInputStream(inputStream, partPath, realPath);
                verifyInfo = verifyService.verify(realPath).getData();
                if (verifyInfo.getName() != null && !verifyInfo.getName().equals("")) {
                    form.setFacadePath(partPath.trim());
                    if (verifyInfo.getName().equals(name)) {
                        if (verifyInfo.getId_number().equals(idCardNo)) {
                            form.setApiResult(1);
                        } else {
                            form.setApiResult(-1);
                        }

                    } else {
                        form.setApiResult(-1);
                    }
                } else {
                    form.setBackPath(partPath.trim());
                    String[] date = verifyInfo.getValidity().split("-");
                    Date date1 = simpleDateFormat1.parse(date[1]);
                    if (System.currentTimeMillis() > date1.getTime()) {
                        return "证件过时";
                    }
                }
            }
            liveRoomService.addFormRequest(form);
            return "表单已提交,请等待管理员审核";
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return "网络出错,请稍后再试";
    }

    @PostMapping("/allRequestForm")
    @ResponseBody
    public List<RequestForm> allRequestForm() {
        return liveRoomService.allRequestForm();
    }

    @PostMapping("/addLive")
    @ResponseBody
    public void addLive(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        User user = userService.selectUser(userId);
        System.out.println(user);
        LiveRoom liveRoom = new LiveRoom();
        liveRoom.setUserId(user.getUserId());
        liveRoom.setNickname(user.getUsername());
        liveRoom.setRoomName("room" + user.getUserId());
        System.out.println(liveRoom);
        String url = "http://push.chenchiding.com/kd-27/18242289538" + user.getUserId() + ".flv";
        liveRoom.setRoomUri(url);
        liveRoomService.addLive(liveRoom);
        userService.addRole("STREAMER", user.getUserId());
        liveRoomService.agreeRequest(requestId);
    }

    @PostMapping("/disagree")
    @ResponseBody
    public void disagree(HttpServletRequest request) {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        liveRoomService.disagreeRequest(requestId);
    }

    @PostMapping("/searchLive")
    @ResponseBody
    public LiveRoom searchLive(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        return liveRoomService.searchLiveByUserId(userId);
    }

    @PostMapping("/updateLiveInfo")
    @ResponseBody
    public LiveRoom updateLiveInfo(LiveRoom liveRoom, @RequestPart(value = "img1") MultipartFile multipartFile, HttpServletRequest request) {
        System.out.println(liveRoom);
        try {
            InputStream inputStream = multipartFile.getInputStream();
            String partPath = "resources/user_resources/img/" + liveRoom.getUserId() +"/"+ simpleDateFormat.format(new Date()) + multipartFile.getOriginalFilename();
            String realPath = request.getServletContext().getRealPath(partPath);
            System.out.println(realPath);
            fileService.keepFileByInputStream(inputStream, partPath, realPath);
            liveRoom.setImg(partPath);
            System.out.println(liveRoom);
            liveRoomService.updateLiveInfo(liveRoom);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liveRoomService.searchLiveByUserId(liveRoom.getUserId());
    }

}
