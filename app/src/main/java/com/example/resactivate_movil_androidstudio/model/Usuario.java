package com.example.resactivate_movil_androidstudio.model;

public class Usuario {
    int id;
    String nombre;
    String apellido;
    String cedula;
    String fechaNacimiento;
    String telefono;
    String email;
    String password;
    int aceptaTyCondiciones;//boolean

    //constructores
    public Usuario() {
    }


    //get y set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAceptaTyCondiciones() {
        return aceptaTyCondiciones;
    }

    public void setAceptaTyCondiciones(int aceptaTyCondiciones) {
        this.aceptaTyCondiciones = aceptaTyCondiciones;
    }
}
