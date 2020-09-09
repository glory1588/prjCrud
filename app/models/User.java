/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Calendar;
import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * .
 *
 * @author GloriaPC
 */
@Entity
public class User extends Model {

    public String name;
    public String email;
    public String contrasena;
    public int anoNacimiento;
    /*@Transient // no sera creado en la bd
    public int edad;
*/
    public int getEdad() {
        return Calendar.getInstance().get(Calendar.YEAR) - anoNacimiento;
    }
}
