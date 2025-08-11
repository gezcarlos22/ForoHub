create table usuarios(
                         id bigint not null auto_increment,
                         login varchar(100) not null,
                         contrasena varchar(255) not null,
                         perfil_id bigint not nulL,


                         primary key(id),
                         constraint fk_usuario_perfil foreign key(perfil_id) references perfiles(id)
);