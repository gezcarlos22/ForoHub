package com.gezcarlos.ForoHub.domain.repuesta;

import com.gezcarlos.ForoHub.domain.topicos.Topico;
import com.gezcarlos.ForoHub.domain.usuarios.Usuario;
import java.time.LocalDateTime;

public record DatosDetallesRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        String topico
) {
    public DatosDetallesRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getAutor().getId().toString(),
                respuesta.getTopico().getId().toString()

        );

    }
}