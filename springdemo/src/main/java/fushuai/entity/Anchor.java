package fushuai.entity;

import org.apache.ibatis.type.Alias;

@Alias("anchor")
public class Anchor {
    private int id;
    private String anchorName;
    private int roomcode;
    private String address;
    private int uId;
    private int statement;
    private String icon;
    private String title;
    private String addressload;

    public String getAddressload() {
        return addressload;
    }

    public void setAddressload(String addressload) {
        this.addressload = addressload;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public void setAnchorName(String anchorName) {
        this.anchorName = anchorName;
    }

    public int getRoomcode() {
        return roomcode;
    }

    public void setRoomcode(int roomcode) {
        this.roomcode = roomcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getStatement() {
        return statement;
    }

    public void setStatement(int statement) {
        this.statement = statement;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
