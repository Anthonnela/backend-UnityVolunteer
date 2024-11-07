package com.acme.backendunityvolunteer.interfaces.persistence;

import com.acme.backendunityvolunteer.domain.model.Puntuacion;
import com.acme.backendunityvolunteer.domain.model.repository.PuntuacionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPuntuacionRepository extends JpaRepository<Puntuacion, Long>, PuntuacionRepository {
}
