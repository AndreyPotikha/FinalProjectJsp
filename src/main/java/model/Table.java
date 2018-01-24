package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
public class Table {

    private String name;
    private String diagonal;
    private String wifi;
    private String os;
    private String imgPath;
}
