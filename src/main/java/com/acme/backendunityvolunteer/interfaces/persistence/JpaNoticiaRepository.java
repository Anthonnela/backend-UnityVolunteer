package com.acme.backendunityvolunteer.interfaces.persistence;

import com.acme.backendunityvolunteer.domain.model.Noticia;
import com.acme.backendunityvolunteer.domain.model.repository.NoticiaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaNoticiaRepository extends JpaRepository<Noticia, Long>, NoticiaRepository {
}
