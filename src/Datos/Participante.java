package Datos;

import java.util.Date;
public class Participante {
    private int id_participante;
    private String nombre_participante;
    private String direccion;
    private String telefono;
    private Date fecha_nacimiento;
    private String lugar_nacimiento;
    private String estado_civil;

    public Participante() {
    }

    public Participante(int id_participante, String nombre_participante, String direccion, String telefono, Date fecha_nacimiento, String lugar_nacimiento, String estado_civil) {
        this.id_participante = id_participante;
        this.nombre_participante = nombre_participante;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.estado_civil = estado_civil;
    }

    public int getId_participante() {
        return id_participante;
    }
    public void setId_participante(int id_participante) {
        this.id_participante = id_participante;
    }
    public String getNombre_participante() {
        return nombre_participante;
    }
    public void setNombre_participante(String nombre_participante) {
        this.nombre_participante = nombre_participante;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }
    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }
    public String getEstado_civil() {
        return estado_civil;
    }
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

}
