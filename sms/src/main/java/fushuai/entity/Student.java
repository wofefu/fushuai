package fushuai.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Long id;

    private String sname;

    @JSONField(format="yyyy-MM-dd")
    private Date birthday;

    private String gender;

    private String telephone;

    private String email;

    private Long classid;

    private static final long serialVersionUID = 1L;
}