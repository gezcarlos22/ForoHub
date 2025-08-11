package com.gezcarlos.ForoHub.domain.topicos;

import com.gezcarlos.ForoHub.domain.cursos.Curso;
import com.gezcarlos.ForoHub.domain.perfiles.DatosPerfil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopicos(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @Valid
        DatosPerfil autor,
        @NotNull
        Curso curso

) {
}
