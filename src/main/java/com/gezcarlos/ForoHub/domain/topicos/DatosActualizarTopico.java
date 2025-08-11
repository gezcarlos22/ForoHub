package com.gezcarlos.ForoHub.domain.topicos;


import com.gezcarlos.ForoHub.domain.cursos.Curso;
import com.gezcarlos.ForoHub.domain.perfiles.DatosPerfil;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        Curso curso,
        DatosPerfil autor


) {


}
