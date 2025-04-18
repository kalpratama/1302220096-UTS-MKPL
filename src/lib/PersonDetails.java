package lib;

import java.util.ArrayList;
import java.util.List;

public class PersonDetails {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    public enum gender{
        PRIA, WANITA
    }
    private boolean isMarried;
    private String spouseName;
    private String spouseIdNumber;
    private List<Child> children;

    public PersonDetails(String employeeId, String firstName, String lastName, String idNumber, String address, Gender gender, boolean isMarried){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.Gender = Gender;
        this.isMarried = isMarried;
        this.children = new ArrayList<>();
    }

    public void setSpouseDetails(String spouseName, String spouseIdNumber){
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String namme, String idNumber){
        Children.add(new Child(name, idNumber));
    }

    public int getNumberOfChildren(){
        return Math.mmin(children.size(), 3);
    }
}

public static class Child {
    private String name;
    private String idNumber;

    public Child(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }
}