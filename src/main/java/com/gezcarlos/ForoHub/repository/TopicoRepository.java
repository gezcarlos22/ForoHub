package com.gezcarlos.ForoHub.repository;

import com.gezcarlos.ForoHub.domain.topicos.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    Page<Topico> findAllByStatusTrue(Pageable paginacion);

    Topico findByIdAndStatusTrue(Long id);
}