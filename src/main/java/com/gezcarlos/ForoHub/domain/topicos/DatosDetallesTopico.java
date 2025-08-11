package com.gezcarlos.ForoHub.domain.topicos;

import com.gezcarlos.ForoHub.domain.perfiles.Perfil;

import java.time.LocalDateTime;

public record DatosDetallesTopico(
        Long id,
        String titulo,
        String mensaje,
        Perfil autor,
        LocalDateTime fechaCreacion,
        String curso



) {
    public DatosDetallesTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getFechaCreacion(),
                String.valueOf(topico.getCurso()));

        ;}
}
