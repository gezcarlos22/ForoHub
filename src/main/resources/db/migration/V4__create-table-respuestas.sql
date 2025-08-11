create table respuestas (
                            id bigint not null auto_increment,
                            mensaje text not null,
                            fecha_creacion datetime not null,
                            autor_id bigint not null,
                            topico_id bigint not null,
                            status boolean not null default true,

                            primary key (id),

                            constraint fk_respuesta_autor foreign key (autor_id) references usuarios(id),
                            constraint fk_respuesta_topico foreign key (topico_id) references topicos(id)
);