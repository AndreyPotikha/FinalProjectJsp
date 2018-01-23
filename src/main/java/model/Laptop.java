package model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
public class Laptop {

    private String name;
    private String cpu;
    private String ram;
    private String videoCard;
    private String hardMemory;
}
