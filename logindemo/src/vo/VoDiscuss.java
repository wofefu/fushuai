package vo;

import entity.Discuss;
import entity.User;

public class VoDiscuss extends Discuss {
    private String nickName;
    private String icon;

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
}
