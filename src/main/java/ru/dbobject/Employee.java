package ru.dbobject;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int E_Id;
    private String E_Title;
    private String E_Salary;
}