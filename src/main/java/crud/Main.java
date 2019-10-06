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


    public static void main(String[] args) {
        Map<String,Object> values = new HashMap<>();
        port(4999);
        staticFiles.location("/spark/template/freemarker");



        before("/",(request, response) -> {
            User user = request.session().attribute("user");
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

                reponse.redirect("/");
            }else{
                reponse.redirect("/login");
            }
            return "";
        });
        post("/crud",(request,response)->{
                Student student = new Student(request.queryParams("id_student"),request.queryParams("name"),
                        request.queryParams("last_name"),request.queryParams("phone"));
                Session session = request.session(true);
                session.attribute("student",student);
                values.put("student",student);
                response.redirect("/");

            return "";
        });

        get("/",(request,response)->{
            Session session = request.session();

            User user = session.attribute("user");
           // Map<String,Object> values = new HashMap<>();
            values.put("user",user);
            values.forEach((key,value)-> System.out.println(key + ":" +value.toString()));

            return renderFreemarker(values,"crud.ftl");
        });





    }


    public static String renderFreemarker(Map<String, Object> model, String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }




}
