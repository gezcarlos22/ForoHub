package com.gezcarlos.ForoHub.controller;
import com.gezcarlos.ForoHub.domain.perfiles.Perfil;
import com.gezcarlos.ForoHub.repository.PerfilRepository;
import com.gezcarlos.ForoHub.domain.topicos.*;
import com.gezcarlos.ForoHub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.hateoas.EntityModel;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private PagedResourcesAssembler<DatosListaTopicos> pagedResourcesAssembler;
    @Autowired
    private DatoslistaTopicosModelAssembler datosListaTopicosModelAssembler;

    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    PerfilRepository perfilRepository;

    @Transactional
    @PostMapping
    public ResponseEntity crearTopico(@RequestBody @Valid DatosTopicos datos, UriComponentsBuilder uriBuilder) {
        Perfil perfil = perfilRepository.findById(datos.autor().id())
                .orElseThrow(() -> new RuntimeException("No se encontro el autor"+datos.autor().id()));
        var topico = new Topico(datos,perfil);
        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}")
                .buildAndExpand(topico.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DatosDetallesTopico(topico));
    }
    @GetMapping
    public PagedModel<EntityModel<DatosListaTopicos>> listarTopicos(@PageableDefault(size = 10, sort = {"fechaCreacion","curso"}, direction = Sort.Direction.ASC) Pageable paginacion){
        Page<DatosListaTopicos> pagina = topicoRepository.findAllByStatusTrue(paginacion).map(DatosListaTopicos::new);
        return pagedResourcesAssembler.toModel(pagina,datosListaTopicosModelAssembler);
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datos) {
        var topico = topicoRepository.getReferenceById(datos.id());

        topico.actualizarDatos(datos);
        return ResponseEntity.ok(new DatosDetallesTopico(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetallesTopico> detallesTopico(@PathVariable Long id) {
        var topico = topicoRepository.findByIdAndStatusTrue(id);
        return ResponseEntity.ok(new DatosDetallesTopico(topico));
    }



}
