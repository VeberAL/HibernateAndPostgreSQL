package ru.dbobject;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    private int E_Id;
    private String E_Title;
    private int E_Salary;
}