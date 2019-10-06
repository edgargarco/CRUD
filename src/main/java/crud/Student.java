package crud;

import java.util.ArrayList;

public class Student {
    private String student_id;
    private String name;
    private String last_name;
    private String tel;


    public Student(){

    }

    public Student(String student_id, String name, String last_name, String tel) {
        this.student_id = student_id;
        this.name = name;
        this.last_name = last_name;
        this.tel = tel;

    }



    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
