package com.acme.backendunityvolunteer.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "puntuaciones")
public class Puntuacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_voluntario", nullable = false)
    private PerfilVoluntario voluntarioId;

    @ManyToOne
    @JoinColumn(name = "id_actividad", nullable = false)
    private Actividad actividadId;

    @Column(nullable = false)
    private int calificacion;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    @Column(nullable = false)
    private Date fecha;
}