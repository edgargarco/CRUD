package crud;

import lombok.Getter;
import lombok.Setter;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.*;

import spark.Session;

import static spark.Spark.*;

@Setter
@Getter

public class Main {
    private static ArrayList<Student> list_Student = new ArrayList<>();
    private static int id = 0;



    public static void main(String[] args) {
        Map<String,Object> values = new HashMap<>();
        port(4999);
        staticFiles.location("/spark/template/freemarker");




        before("/",(request, response) -> {
            User user = request.session().attribute("user");
           // values.forEach((key,value)-> System.out.println(key + ":" +value.toString()));

            if(user == null){
                response.redirect("/login");
                halt();
            }
        });



        get("/login",(request, response) ->{
            return renderFreemarker(null,"login.ftl");
        } );



        post("/autenticar",(request,reponse)->{


            User user = new User(request.queryParams("usuario"),request.queryParams("password"));
            if(user.getEmail().equals("edgar@hotmail.com") && user.getPassword().equals("123") || user.getEmail().equals("pepe@hotmail.com") && user.getPassword().equals("123")){
                user.setUser("Edgar Garcia");
                Session session = request.session(true);

                session.attribute("user",user);
                Student x = new Student("20161143", "Edgar","Garcia","8293819028");
                insertStudent(x);

                values.put("student",list_Student);
                System.out.println(list_Student.get(0).getName());

                reponse.redirect("/");
            }else{
                reponse.redirect("/login");
            }
            return "";
        });
        post("/crud",(request,response)->{
            if(request.queryParams("id_student").equalsIgnoreCase("") || request.queryParams("name").equalsIgnoreCase("")
            || request.queryParams("last_name").equalsIgnoreCase("") || request.queryParams("phone").equalsIgnoreCase("")){
                response.redirect("/");
            }else{
                Student student = new Student(request.queryParams("id_student"),request.queryParams("name"),
                        request.queryParams("last_name"),request.queryParams("phone"));

                Session session = request.session(true);
                insertStudent(student);
                for (int i = 0;i<list_Student.size();i++){
                    System.out.println(list_Student.get(i).getId()+"->"+list_Student.get(i).getName());
                }
                session.attribute("student", list_Student);
                values.put("student",list_Student);
                response.redirect("/");

            }


            return "";
        });

        post("/delete",(request,response)->{
            int aux_id = Integer.parseInt(request.queryParams("id"));
            System.out.println(aux_id);
            Student aux_student = searchStudent(aux_id);
            System.out.println(aux_student.getId());
            aux_student.getName();
            list_Student.remove(aux_student);
            response.redirect("/");

            return "";
        });

        post("/update",(request,response)->{
            int aux_id = Integer.parseInt(request.queryParams("id"));
            System.out.println(aux_id);
            for (int i =0;i<list_Student.size();i++){
                if(list_Student.get(i).getId() == aux_id){
                    /*System.out.println("->"+request.queryParams("student_id"));
                    System.out.println("->"+request.queryParams("name"));
                    System.out.println("->"+request.queryParams("last_name"));
                    System.out.println("->"+request.queryParams("tel"));*/
                    list_Student.get(i).setStudent_id(request.queryParams("student_id"));
                    list_Student.get(i).setName(request.queryParams("name"));
                    list_Student.get(i).setLast_name(request.queryParams("last_name"));
                    list_Student.get(i).setTel(request.queryParams("tel"));
                    /*System.out.println(list_Student.get(i).getName());
                    System.out.println(list_Student.get(i).getLast_name());
                    System.out.println(list_Student.get(i).getStudent_id());
                    System.out.println(list_Student.get(i).getTel());*/
                }
            }
            response.redirect("/");

            return "";
        });

        get("/",(request,response)->{
            Session session = request.session();
            User user = session.attribute("user");;
            values.put("usuario",user);


            return renderFreemarker(values,"crud.ftl");
        });





    }


    public static String renderFreemarker(Map<String, Object> model, String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }
    public ArrayList<Student> getList_Student() {
        return list_Student;
    }

    public void setList_Student(ArrayList<Student> list_Student) {
        this.list_Student = list_Student;
    }
    public static void insertStudent(Student student){
        id++;
        student.setId(id);
        list_Student.add(student);
    }

    public static Student searchStudent(int id){
        Student aux_student=null;
        for (int i=0;i<list_Student.size();i++){
            System.out.println("ID"+i+"->"+list_Student.get(i).getId());
            if (list_Student.get(i).getId() == id){
                aux_student = list_Student.get(i);
                return aux_student;
            }

        }
        return aux_student;
    }





}
