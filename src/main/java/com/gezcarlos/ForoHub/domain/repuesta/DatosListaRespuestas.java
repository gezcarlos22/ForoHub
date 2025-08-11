package com.gezcarlos.ForoHub.domain.repuesta;

import java.time.LocalDateTime;

public record DatosListaRespuestas(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autorId,
        String topicoId

) {
    public DatosListaRespuestas(Respuesta respuesta) {
        this(respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getAutor().getId().toString(),
                respuesta.getTopico().getId().toString()
        );

    }}
