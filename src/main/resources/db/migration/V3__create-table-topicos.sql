create table topicos(
                        id bigint not null auto_increment,
                        titulo varchar(100) not null unique,
                        mensaje text not null,
                        fecha_creacion datetime not null,
                        status varchar(20) not null,
                        nombre_autor varchar(100) not null,
                        curso varchar(100) not null,

                        primary key (id),

                        usuario_id bigint not null,
                        constraint fk_topico_usuario  foreign key(usuario_id) references usuarios(id)
);