package vo;

import entity.MiniBlog;

public class VominiBlog extends MiniBlog {
    private String nickName;
    private String icon;
    private Integer uId;

    public VominiBlog() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "VominiBlog{" +
                "nickName='" + nickName + '\'' +
                ", icon='" + icon + '\'' +
                ", uId=" + uId +
                '}';
    }
}
