package com.example.demo.entity.jpa;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class DataJpa {
    //Vo类就不用以一个类单独写出来了，用注解JsonView就可以了
    //vo视图对象模型  一条微博框内的信息抽象成一个数据对象
    //基础信息
    public interface Base{}
    //细节信息
    public interface Detail extends Base{};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    @JsonView({Base.class})
    private String username;
    @Column(length = 20)
    private String password;
    @Column(length = 20)
    @JsonView({Base.class})
    private String nickname;
    @JsonView(value = Detail.class)
    private Date birthday;


    private int Fans;
//想让属性不成为数据表中的列
    @org.springframework.data.annotation.Transient
    private int date;

}
