package com.acme.backendunityvolunteer.infraestructure.rest;

import com.acme.backendunityvolunteer.application.dto.PuntuacionDTO;
import com.acme.backendunityvolunteer.application.dto.user_management.PuntuacionService;
import com.acme.backendunityvolunteer.domain.model.Puntuacion;
import com.acme.backendunityvolunteer.infraestructure.rest.dto.PuntuacionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/puntuaciones")
public class PuntuacionController {

    @Autowired
    private PuntuacionService puntuacionService;

    @PostMapping
    public ResponseEntity<String> agregarPuntuacion(@RequestBody PuntuacionRequest request) {
        PuntuacionDTO puntuacionDTO = new PuntuacionDTO();
        puntuacionDTO.setVoluntarioId(request.getVoluntarioId());
        puntuacionDTO.setActividadId(request.getActividadId());
        puntuacionDTO.setCalificacion(request.getCalificacion());
        puntuacionDTO.setComentario(request.getComentario());
        puntuacionDTO.setFecha(request.getFecha());

        PuntuacionDTO puntuacionGuardada = puntuacionService.addPuntuacion(puntuacionDTO);

        return ResponseEntity.ok("Puntuación registrada con éxito");
    }
}