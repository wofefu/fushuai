package fushuai.dto;

import fushuai.entity.Classes;
import fushuai.entity.Student;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentClass implements Serializable {
    private Long id;

    private String cname;

    private List<Student> students;

}
