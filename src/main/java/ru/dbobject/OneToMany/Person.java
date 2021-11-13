package ru.dbobject.OneToMany;
import lombok.*;

@Data
public class Person {
    private int P_Id;
    private String P_FirstName;
    private String P_LastName;
    private int P_Age;
    private String P_Gender;
    private String P_City;
    private Employees employees;
}