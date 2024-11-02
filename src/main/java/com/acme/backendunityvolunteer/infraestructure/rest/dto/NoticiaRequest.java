package com.acme.backendunityvolunteer.infraestructure.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NoticiaRequest {

    @NotNull(message = "El título no puede estar vacío")
    private String titulo;

    @NotNull(message = "La descripción no puede estar vacío")
    private String descripcion;

    @NotNull(message = "La fecha de publicacion no puede estar vacío")
    private Date fechaPublicacion;

    @NotNull(message = "El id de la actividad es obligatorio")
    private Long actividadId;
}
