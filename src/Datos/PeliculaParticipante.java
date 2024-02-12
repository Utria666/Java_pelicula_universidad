package Datos;

import java.util.Date;
public class PeliculaParticipante {

    private int id_pelicula;

    private Pelicula pelicula;

    private  int id_participante;

    private Participante participante;

    private  int id_cargo;

    private CargoParticipante cargoParticipante;

    private  int id_papel;

    private TipoPapel tipoPapel;

    private double sueldo;

    // Constructor vacío
    public PeliculaParticipante() {
    }

    // Constructor para inserción, actualización y eliminación
    public PeliculaParticipante(int id_pelicula, int id_participante, int id_cargo, int id_papel, double sueldo) {
        this.id_pelicula = id_pelicula;
        this.id_participante = id_participante;
        this.id_cargo = id_cargo;
        this.id_papel = id_papel;
        this.sueldo = sueldo;
    }

    // Constructor para consultar debido a la relación con otras clases
    public PeliculaParticipante(int id_pelicula, int id_participante, int id_cargo, int id_papel, double sueldo, Pelicula pelicula, Participante participante, CargoParticipante cargoParticipante, TipoPapel tipoPapel) {
        this(id_pelicula, id_participante, id_cargo, id_papel, sueldo);
        this.pelicula = pelicula;
        this.participante = participante;
        this.cargoParticipante = cargoParticipante;
        this.tipoPapel = tipoPapel;
    }

    // Getters y Setters
    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public int getId_participante() {
        return id_participante;
    }

    public void setId_participante(int id_participante) {
        this.id_participante = id_participante;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public CargoParticipante getCargoParticipante() {
        return cargoParticipante;
    }

    public void setCargoParticipante(CargoParticipante cargoParticipante) {
        this.cargoParticipante = cargoParticipante;
    }

    public int getId_papel() {
        return id_papel;
    }

    public void setId_papel(int id_papel) {
        this.id_papel = id_papel;
    }

    public TipoPapel getTipoPapel() {
        return tipoPapel;
    }

    public void setTipoPapel(TipoPapel tipoPapel) {
        this.tipoPapel = tipoPapel;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}
