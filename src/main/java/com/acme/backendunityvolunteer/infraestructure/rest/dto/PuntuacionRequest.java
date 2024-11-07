package com.acme.backendunityvolunteer.infraestructure.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PuntuacionRequest {
    private Long voluntarioId;
    private Long actividadId;
    private int calificacion;
    private String comentario;
    private Date fecha;
}
