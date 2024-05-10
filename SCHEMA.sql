DROP DATABASE IF EXISTS FacturaElectronica_2;
CREATE DATABASE FacturaElectronica_2;
USE FacturaElectronica_2;

create table usuarios (
  identificacionu varchar(20) not null,
  nombreu varchar(20) not null,
  contrasenia varchar(30) not null,
  tipo varchar(20) not null,
  tipo_Persona varchar(20),
  aprobado BOOLEAN NOT NULL DEFAULT FALSE
);

create table productos(
 idproducto INT AUTO_INCREMENT PRIMARY KEY,
 codigo varchar(20) not null,
 descripcion varchar(30) not null,
 precio FLOAT not null,
 proveedorp varchar(20) not null
);

create table clientes (
  idcliente INT AUTO_INCREMENT PRIMARY KEY,
  identificacionc varchar(20) not null,
  nombrec varchar(30) not null,
  correo varchar(20) not null,
  telefono INTEGER not null,
  proveedorc varchar(20) not null
);

CREATE TABLE facturas (
    idfactura INT AUTO_INCREMENT PRIMARY KEY,
    identificacion_usuario VARCHAR(20) NOT NULL,
    identificacion_cliente INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE detalles (
    iddetalle INT AUTO_INCREMENT PRIMARY KEY,
    idfacdetalle INT NOT NULL,
    codigoproducto INT NOT NULL,
    cantidad INT NOT NULL,
    descripciondetalle VARCHAR(100) NOT NULL,
    valorfinal FLOAT NOT NULL
);

alter table usuarios add constraint usuarios_pk primary key (identificacionu);

alter table productos add foreign key (proveedorp) references usuarios(identificacionu);
alter table clientes add foreign key (proveedorc) references usuarios(identificacionu);

alter table facturas add foreign key (identificacion_usuario) references usuarios(identificacionu);
alter table facturas add foreign key (identificacion_cliente) references clientes(idcliente);

alter table detalles add foreign key (idfacdetalle) references facturas(idfactura);
alter table detalles add foreign key (codigoproducto) references productos(idproducto);



alter table usuarios add constraint tipo_ck Check
(tipo in ('PRO','ADM') ); 

alter table usuarios add constraint tipoPersona_ck Check
(tipo_Persona in ('JUR','FIS','') ); 

alter table productos add constraint precio_ck Check
(precio > 0 ); 

alter table clientes add constraint telefono_ck Check
(telefono > 0 ); 



insert into usuarios (identificacionu,nombreu,contrasenia,tipo,tipo_Persona) values ('1','pedrito','123','PRO','FIS');
insert into usuarios (identificacionu,nombreu,contrasenia,tipo,tipo_Persona) values ('2','jairo','1','PRO','FIS');
insert into usuarios (identificacionu,nombreu,contrasenia,tipo,tipo_Persona) values ('3','Juana','123','ADM','');


insert into productos ( codigo, descripcion, precio,proveedorp) values ('001','Queque seco',1500,'1');
insert into productos ( codigo, descripcion, precio,proveedorp) values ('002','Queque mojado',2000,'1');

insert into clientes ( identificacionc, nombrec, correo,telefono,proveedorc) values ('gvega','Gabriel Vega','gvega@gmail.com',11111111,'1');


insert into facturas (identificacion_usuario, identificacion_cliente) values ('1', 'gvega');


insert into detalles (idfacdetalle, codigoproducto, cantidad, descripciondetalle, valorfinal) values (5, 1, 2, 'Queque seco', 3000.0);
insert into detalles (idfacdetalle, codigoproducto, cantidad, descripciondetalle, valorfinal) values (6, 2, 1, 'Queque mojado', 2000.0);