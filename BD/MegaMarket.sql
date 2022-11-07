DROP DATABASE IF EXISTS megamarket;
CREATE DATABASE  megamarket;
USE MEGAMARKET;

CREATE TABLE tb_tipos(
id_tipo  int not null primary key,
des_tipo varchar(20)
);
CREATE TABLE tb_categorias(
idtipo		int not null primary key,
descripcion varchar(45)
);

CREATE TABLE tb_proveedores(
id_Proveedor int auto_increment primary key,
razon_social  varchar(25),
telefono  char(9),
ruc char(11),
correo varchar(50),
tipo int default 1,
estado  int(1) DEFAULT 1, -- ???
-- primary key (id_Proveedor),
foreign key(tipo) references tb_tipos (id_tipo)
);

CREATE TABLE tb_transportistas(
id_transportista int auto_increment,
nombre varchar(20),
apellidos varchar(20),
dni char(8),
empresa int,
correo varchar(50),
tipo int default 2,
estado  int(1) DEFAULT 1,
primary key (id_transportista),
foreign key(tipo) references tb_tipos(id_tipo)
);
CREATE TABLE tb_productos(
id_producto  int auto_increment,
nombre varchar(20),
fecha date,
stock int,
empresa int,
tipo int default 2,
estado  int(1) DEFAULT 1,
primary key (id_producto),
foreign key(tipo) references tb_categorias(idtipo)
);

CREATE TABLE tb_tipoEmpresa(
id_tipo  int not null primary key,
descripcion varchar(45)
);

-- Tablas de Trabajadores ---------------
Create Table tb_TipoEmpleado
(
Id_tipo_emple int(1) not null primary key,
Descripcion varchar(45)
);

Create Table tb_Empleado
(
Codigo int auto_increment primary key,
Nombre varchar(20) not null,
Apellido varchar(20) not null,
Dni char(8) not null,
Usuario char(4) not null,
Clave char(4) not null,
Fecha_Nacimiento date not null,
Tipo_empleado int not null default 1, 
foreign key(Tipo_empleado) references tb_TipoEmpleado(Id_tipo_emple)
);

insert into tb_TipoEmpleado values(1, 'Trabajador');
insert into tb_TipoEmpleado values(2, 'Administrador');

insert into tb_Empleado values(null,'Kevin','Basilio', '48082618','U001','P001','2020/01/01',1);
insert into tb_Empleado values(null,'Michael','Jackson', '54269854','U003','P003','2020/01/01',2);

DELIMITER $$
CREATE PROCEDURE usp_validarEmpleado(usr char(4), pas char(4))
BEGIN
select * from tb_Empleado
where Usuario = usr and Clave = pas;
END $$
DELIMITER ;

CALL usp_validarEmpleado ('U001','C001'); 

-- TABLAS PARA TRANSACCION (REPORTE DE RECEPCION) ---------------------
create table tb_cab_reporte(
num_reporte    char(5) not null,
fch_reporte    date,
id_proveedor  int not null,
dni_transportista char(8),
primary key (num_reporte),
foreign key (id_proveedor) references tb_proveedores(id_Proveedor)
);

create table tb_det_reporte(
num_reporte     char(5) not null,
idprod      int not null,
cantidad    int,
primary key (num_reporte,idprod),
foreign key (num_reporte) references tb_cab_reporte(num_reporte),
foreign key (idprod) references tb_productos(id_producto)
);
-----------------------------------------------------------------------


insert into tb_tipos values(1, 'Proveedor');
insert into tb_tipos values(2, 'Transportista');
insert into tb_tipos values(3, 'Producto');

insert into tb_proveedores values(null,'Binmbo','965629142','20202020154','bimbo@bimbo.com.pe',1,1);
insert into tb_proveedores values(null,'Coca Cola','965629142','20202020154','CocaCola@coke.com.pe',1,1);
insert into tb_proveedores values(null,'Nicolini','965629142','20202020154','Nicolini@nico.com.pe',1,1);

insert into tb_tipoEmpresa values(1,"Bimbo");
insert into tb_tipoEmpresa values(2,"Coca Cola");
insert into tb_tipoEmpresa values(3,"Nicolini");

insert into tb_transportistas values(null,'Manuel','Ruiz','69856345',1,'RuizBim@bimbo.com.pe',default,default);
insert into tb_transportistas values(null,'Angel','Torres','35986254',2,'TorresCoc@Coke.com.pe',default,default);
insert into tb_transportistas values(null,'Oscar','Condori','26589652',3,'CondoriNic@nico.com.pe',default,default);

insert into tb_categorias values(1,'Galleta');
insert into tb_categorias values(2,'Piqueos');
insert into tb_categorias values(3,'Gaseosas');

insert into tb_productos values(null,'Galleta Oreo','2022/11/10','150',1,1,1);
insert into tb_productos values(null,'Papas Lays','2022/08/17','85',2,2,1);
insert into tb_productos values(null,'Sprite','2023/01/02','145',3,3,1);

insert into tb_cab_reporte values ('R0001','2021/11/29', 2,'69856325');




