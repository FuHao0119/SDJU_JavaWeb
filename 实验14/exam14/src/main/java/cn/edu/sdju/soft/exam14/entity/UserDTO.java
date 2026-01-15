package cn.edu.sdju.soft.exam14.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    String username;
    String password;
    Integer age;
    String gender;
    String email;
}
