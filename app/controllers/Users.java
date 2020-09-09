/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.User;
import play.mvc.Controller;

/**
 *
 * @author GloriaPC
 */
public class Users extends Controller {

    //localhost:9000/usuarios/form
    public static void form() {
        render();
    }

    public static void save(User usu) {
        usu.save();
        form();
    }
    /*
     pulic static void list() {
     String busca = params.get("busca");
     List<Usuario> lista= Usuario.findAll();
     /* for (int i = 0; i < lista.size(); i++) {
     lista.get(i).edad = Calendar.getInstance().get(Calendar.YEAR) - lista.get(i).anoNacimiento;
     }

     //  String name="Maria";
     if (busca == null) {
     lista = Usuario.findAll();
     } else {
     lista = Usuario.find("name LIKE ?1 OR email LIKE ?1", "%" + busca + "%").fetch();
     }
     render(lista);

     }*/

    public static void list() {
        String search= params.get("txtSearch");
        List<User> listU= User.findAll();
        if (search == null) {
            listU = User.findAll();
        } else {
            listU = User.find("name LIKE ?1 OR email LIKE ?1", "%" + search + "%").fetch();
        }
        render(listU);

    }

    public static void edit(long id) {
        User usu = User.findById(id);
        renderTemplate("Users/form.html", usu);
    }

    public static void delete(long id) {
        User usu = User.findById(id);
        usu.delete();
        list();
    }
}
