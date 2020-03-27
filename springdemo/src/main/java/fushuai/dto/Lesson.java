package fushuai.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
//dto数据转义对象
public class Lesson {
    //yyyy年MM月dd日  这样也行
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date date;
    private String username;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
