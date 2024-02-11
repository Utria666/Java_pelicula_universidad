package Logica;

import Datos.Participante;
import Datos.ParticipanteDAO;
import java.util.Date;
import java.util.List;

public class ParticipanteService {
    private ParticipanteDAO participanteDAO;

    public ParticipanteService() {
        this.participanteDAO = new ParticipanteDAO();
    }

    public boolean registrarParticipante(String nombre, String direccion, int telefono, Date fechaNacimiento, String lugarNacimiento, String estadoCivil) {
        Participante participante = new Participante(0, nombre, direccion, telefono, fechaNacimiento, lugarNacimiento, estadoCivil);
        return participanteDAO.insertarParticipante(participante);
    }

    public boolean actualizarParticipante(int idParticipante, String nombre, String direccion, int telefono, Date fechaNacimiento, String lugarNacimiento, String estadoCivil) {
        Participante participante = new Participante(idParticipante, nombre, direccion, telefono, fechaNacimiento, lugarNacimiento, estadoCivil);
        return participanteDAO.actualizarParticipante(participante);
    }

    public boolean eliminarParticipante(int idParticipante) {
        return participanteDAO.eliminarParticipante(idParticipante);
    }

    public List<Participante> listarTodosLosParticipantes() {
        return participanteDAO.obtenerParticipantes();
    }

    public Participante obtenerParticipantePorId(int idParticipante) {
        return participanteDAO.obtenerParticipantePorId(idParticipante);
    }
}
