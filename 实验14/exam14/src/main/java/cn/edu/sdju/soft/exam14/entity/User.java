package cn.edu.sdju.soft.exam14.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer id;
    String username;
    String password;
    Integer age;
    String gender;
    String email;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}

