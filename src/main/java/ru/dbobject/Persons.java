package ru.dbobject;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Persons{
    private int P_Id;
    private String P_FirstName;
    private String P_LastName;
    private int P_Age;
    private String P_Gender;
    private String P_City;
    private int E_Id;
}