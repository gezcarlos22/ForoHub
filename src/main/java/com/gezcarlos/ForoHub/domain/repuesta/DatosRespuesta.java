package com.gezcarlos.ForoHub.domain.repuesta;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record DatosRespuesta(
        @NotNull
        Long id,
        @NotBlank
        String mensaje,
        @NotNull
        Long autorId,
        @NotNull
        Long topicoId
) {
}
