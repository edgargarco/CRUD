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
            if(user.getEmail().equals("edgar@hotmail.com") && user.getPassword().equals("123")){
                user.setUser("Edgar Garcia");
                Session session = request.session(true);

                session.attribute("user",user);
                Student x = new Student("201613231", "edgar","pepe","9283");
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
                Student student = new Student(request.queryParams("id_student"),request.queryParams("name"),
                        request.queryParams("last_name"),request.queryParams("phone"));
            System.out.println(student.getName());
            System.out.println(student.getLast_name());
            System.out.println(student.getStudent_id());
            System.out.println(student.getTel());

            Session session = request.session(true);

            insertStudent(student);
            session.attribute("student", list_Student);
            values.put("student",list_Student);



            response.redirect("/");

            return "";
        });

        get("/",(request,response)->{
            Session session = request.session();
            User user = session.attribute("user");;
            values.put("usuario",user);
//

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




}
