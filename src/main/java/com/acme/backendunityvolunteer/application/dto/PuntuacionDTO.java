package com.acme.backendunityvolunteer.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Setter
@Getter
public class PuntuacionDTO {
    private Long id;
    private Long voluntarioId;
    private Long actividadId;
    private int calificacion;
    private String comentario;
    private Date fecha;
}
