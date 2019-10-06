package crud;

import java.util.ArrayList;

public class Main {
    private ArrayList<Student> students;

    public static void main(String[] args) {

    }

    public void fillArrayList(ArrayList<Student> students){
        if(students == null){
            for (int i =0;i<4;i++){
                Student student = new Student(Integer.toString(i+1),("StudentName# "+Integer.toString(i+1)),("StudentLastName# "+Integer.toString(i+1)),"809-333-333"+Integer.toString(i+1));
                students.add(student);
            }


        }

    }

}
