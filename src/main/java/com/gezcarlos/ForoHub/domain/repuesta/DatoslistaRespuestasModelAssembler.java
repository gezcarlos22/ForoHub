package com.gezcarlos.ForoHub.domain.repuesta;

import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class DatoslistaRespuestasModelAssembler implements RepresentationModelAssembler<DatosListaRespuestas, EntityModel<DatosListaRespuestas>> {
    @Override
    @NotNull
    public EntityModel<DatosListaRespuestas> toModel(@NotNull DatosListaRespuestas datos) {
        return EntityModel.of(datos);
    }}
