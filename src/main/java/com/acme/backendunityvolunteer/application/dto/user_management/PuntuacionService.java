package com.acme.backendunityvolunteer.application.dto.user_management;

import com.acme.backendunityvolunteer.application.dto.PuntuacionDTO;
import com.acme.backendunityvolunteer.domain.model.PerfilVoluntario;
import com.acme.backendunityvolunteer.domain.model.Puntuacion;
import com.acme.backendunityvolunteer.domain.model.repository.ActividadRepository;
import com.acme.backendunityvolunteer.domain.model.repository.PuntuacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acme.backendunityvolunteer.domain.model.repository.PerfilVoluntarioRepository;
import java.time.LocalDate;
import java.util.List;

@Service
public class PuntuacionService {


    @Autowired
    private PuntuacionRepository puntuacionRepository;

    @Autowired
    private PerfilVoluntarioRepository voluntarioRepository;

    @Autowired
    private ActividadRepository actividadRepository;

    public PuntuacionDTO addPuntuacion(PuntuacionDTO puntuacionDTO) {
        Puntuacion newPuntuacion = new Puntuacion();
        PerfilVoluntario voluntario = voluntarioRepository.findById(puntuacionDTO.getVoluntarioId()).orElseThrow();

        newPuntuacion.setVoluntarioId(voluntario);
        newPuntuacion.setActividadId(actividadRepository.findById(puntuacionDTO.getActividadId()).orElseThrow());
        newPuntuacion.setCalificacion(puntuacionDTO.getCalificacion());
        newPuntuacion.setComentario(puntuacionDTO.getComentario());
        newPuntuacion.setFecha(puntuacionDTO.getFecha());

        Puntuacion savedPuntuacion = puntuacionRepository.save(newPuntuacion);

        // Update average score
        updateVoluntarioPuntuacionPromedio(voluntario);

        return maptoDTO(savedPuntuacion);
    }

    private void updateVoluntarioPuntuacionPromedio(PerfilVoluntario voluntario) {
        List<Puntuacion> puntuaciones = puntuacionRepository.findByVoluntarioId(voluntario);
        double average = puntuaciones.stream().mapToInt(Puntuacion::getCalificacion).average().orElse(0.0);
        voluntario.setPuntuacionPromedio(average);
        voluntarioRepository.save(voluntario);
    }

    private PuntuacionDTO maptoDTO(Puntuacion puntuacion) {
        PuntuacionDTO puntuacionDTO = new PuntuacionDTO();
        puntuacionDTO.setId(puntuacion.getId());
        puntuacionDTO.setVoluntarioId(puntuacion.getVoluntarioId().getId());
        puntuacionDTO.setActividadId(puntuacion.getActividadId().getId());
        puntuacionDTO.setCalificacion(puntuacion.getCalificacion());
        puntuacionDTO.setComentario(puntuacion.getComentario());
        puntuacionDTO.setFecha(puntuacion.getFecha());
        return puntuacionDTO;
    }

}