package com.kd27.feng.entity;

public class LiveRoom extends User  {
    private int liveRoomId;
    private int userId;
    private String roomTag;
    private String roomName;
    private String nickname;
    private String roomUri;
    private String img;
    private String anchorStatus;
    private String recording;

    public String getRecording() {
        return recording;
    }

    public void setRecording(String recording) {
        this.recording = recording;
    }

    @Override
    public String toString() {
        return "LiveRoom{" +
                "liveRoomId=" + liveRoomId +
                ", userId=" + userId +
                ", roomTag='" + roomTag + '\'' +
                ", roomName='" + roomName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", roomUri='" + roomUri + '\'' +
                ", img='" + img + '\'' +
                ", anchorStatus='" + anchorStatus + '\'' +
                ", recording='" + recording + '\'' +
                '}';
    }

    public int getLiveRoomId() {
        return liveRoomId;
    }

    public void setLiveRoomId(int liveRoomId) {
        this.liveRoomId = liveRoomId;
    }



    public String getRoomTag() {
        return roomTag;
    }

    public void setRoomTag(String roomTag) {
        this.roomTag = roomTag;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRoomUri() {
        return roomUri;
    }

    public void setRoomUri(String roomUri) {
        this.roomUri = roomUri;
    }

    public String getAnchorStatus() {
        return anchorStatus;
    }

    public void setAnchorStatus(String anchorStatus) {
        this.anchorStatus = anchorStatus;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
