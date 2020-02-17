/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ta_o1
 */
public class Contacto {
    
    private static int id;
    private static String nombre;
    private static String apellido;
    private static String correo;
    private static String telefono;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Contacto.id = id;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Contacto.nombre = nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        Contacto.apellido = apellido;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        Contacto.correo = correo;
    }

    public static String getTelefono() {
        return telefono;
    }

    public static void setTelefono(String telefono) {
        Contacto.telefono = telefono;
    }
    
    
    
}
