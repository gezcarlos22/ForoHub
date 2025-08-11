package com.gezcarlos.ForoHub.controller;

import com.gezcarlos.ForoHub.domain.topicos.*;
import com.gezcarlos.ForoHub.domain.repuesta.*;
import com.gezcarlos.ForoHub.domain.usuarios.Usuario;
import com.gezcarlos.ForoHub.repository.RespuestaRepository;
import com.gezcarlos.ForoHub.repository.TopicoRepository;
import com.gezcarlos.ForoHub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PagedResourcesAssembler<DatosListaRespuestas> pagedResourcesAssembler;

    @Autowired
    private DatoslistaRespuestasModelAssembler datosListaRespuestasModelAssembler;

    @Autowired
    RespuestaRepository respuestaRepository;

    @Transactional
    @PostMapping
    public ResponseEntity crearRespuesta(@RequestBody @Valid DatosRespuesta datos, UriComponentsBuilder uriBuilder) {
        System.out.println("Obtonenemos los datos de la respuesta: " + datos);
        Usuario autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + datos.autorId()));

        Topico topico = topicoRepository.findById(datos.topicoId())
                .orElseThrow(() -> new EntityNotFoundException("Topico no encontrado con ID: " + datos.topicoId()));
        var respuesta = new Respuesta(datos,autor,topico);

        respuestaRepository.save(respuesta);

        var uri = uriBuilder.path("/respuestas/{id}")
                .buildAndExpand(respuesta.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DatosDetallesRespuesta(respuesta));
    }
    @GetMapping
    public PagedModel<EntityModel<DatosListaRespuestas>> listarRespuess(@PageableDefault(size = 10, sort = {"fechaCreacion"}, direction = Sort.Direction.ASC) Pageable paginacion){
        Page<DatosListaRespuestas> pagina = respuestaRepository.findAllByStatusTrue(paginacion).map(DatosListaRespuestas::new);
        return pagedResourcesAssembler.toModel(pagina,datosListaRespuestasModelAssembler);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        var respuesta = respuestaRepository.getReferenceById(id);
        respuesta.desactivarTopico();
        return ResponseEntity.noContent().build();
    }



}