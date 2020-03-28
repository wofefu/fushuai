package fushuai.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDetail implements Serializable {
    private Long id;

    private String sname;

    @JSONField(format="yyyy-MM-dd")
    private Date birthday;

    private String gender;

    private String telephone;

    private String email;

    private String cname;

    private Long classid;

    private String bir;
}
