package model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
public class User {

    private String email;
    private String password;
    private String status;
}
