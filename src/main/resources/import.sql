INSERT INTO estado (estado_id, nombre) VALUES (1, 'En Proceso');
INSERT INTO estado (estado_id, nombre) VALUES (2, 'Creado');
INSERT INTO estado (estado_id, nombre) VALUES (3, 'Finalizado');
INSERT INTO estado (estado_id, nombre) VALUES (4, 'Cancelado');
INSERT INTO estado (estado_id, nombre) VALUES (5, 'Detenido');
INSERT INTO estado (estado_id, nombre) VALUES (6, 'En revision');
INSERT INTO estado (estado_id, nombre) VALUES (7, 'Habilitado');
INSERT INTO estado (estado_id, nombre) VALUES (8, 'Deshabilitado');
INSERT INTO estado (estado_id, nombre) VALUES (9, 'Eliminado');


INSERT INTO responsable (id, nombres,apellidos,correo,cargo) VALUES (1, 'Miguel','Guevara','miguelguevaraalejandro@gmail.com','Analista Programador');
INSERT INTO responsable (id, nombres,apellidos,correo,cargo) VALUES (2, 'Miguel2','Guevara2','miguelguevaraalejandro@gmail.com','Analista Programador');

INSERT INTO usuario(id,responsable_id,estado_id) VALUES (1,1,2); 
INSERT INTO usuario(id,responsable_id,estado_id) VALUES (2,2,2); 

INSERT INTO equipo(id,estado_id) VALUES (1,1);

INSERT INTO equipo_usuarios(equipo_id,usuario_id) VALUES (1,1);
INSERT INTO equipo_usuarios(equipo_id,usuario_id) VALUES (1,2);

INSERT INTO proyecto(id,equipo_id,estado_id,nombre) VALUES (1,1,1,'Notificaciones Automaticas');

INSERT INTO sprint(id,estado_id,numero,proyecto_id,descripcion,fecha_fin,fecha_inicio) VALUES (1,1,1,1,'SPRINT 1','01/01/2024','14/11/2023');

INSERT INTO tarea(id,estado_id,nombre,prioridad,sprint_id) VALUES (1,1,'TAREA 1 PRUEBA','Alta',1);
INSERT INTO subtarea(id,estado_id,tarea_id,apoyo_id,descripcion,nombre,responsable_id,tiempo_empleado_planificado,tiempo_empleado_real,prioridad) values(1,2,1,2,'DESCRIPCION SUBTAREA 1','SUBTAREA 1',1,'15/11/2023','','Muy Alta');
INSERT INTO subtarea(id,estado_id,tarea_id,apoyo_id,descripcion,nombre,responsable_id,tiempo_empleado_planificado,tiempo_empleado_real,prioridad) values(2,1,1,2,'DESCRIPCION SUBTAREA 2','SUBTAREA 2',1,'15/11/2023','','Muy Alta');
INSERT INTO subtarea(id,estado_id,tarea_id,apoyo_id,descripcion,nombre,responsable_id,tiempo_empleado_planificado,tiempo_empleado_real,prioridad) values(3,2,1,2,'DESCRIPCION SUBTAREA 3','SUBTAREA 3',1,'15/11/2023','','Muy Alta');