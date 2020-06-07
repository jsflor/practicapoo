# Descripción de la Práctica
La práctica del presente curso va a consistir en diseñar e implementar un sistema integrado de gestión de
una fábrica artesanal de muebles. Hace años el responsable de una fábrica no haría más que apuntar en un
libro una breve descripción del pedido de un cliente, con los muebles que quiere comprar y las características
de cada uno, junto con algún número de contacto. Hoy en día, debido en parte a la competición entre
fábricas y al deseo de aportar servicios de calidad para poder fidelizar al cliente, las fábricas usan sistemas
de gestión para todo el proceso de fabricación, así como para la venta y la facturación.

Para diferenciarse de otras fábricas y grandes almacenes de muebles, el dueño de la fábrica ha decido que
todos sus muebles estarán fabricados a mano por artesanos especialistas. Por ello, y por los costes de
almacenaje de los muebles, la fabricación de todos los muebles se hace bajo demanda.
En general, son varias las funciones que tiene un sistema de gestión de una fábrica artesanal de muebles:
- Recepción de un pedido de un cliente con los muebles que quiere comprar y las características de
cada uno.
- Asignación por parte del jefe de un pedido a un artesano en la fábrica. Para simplificar la gestión del
proceso en esta práctica, se da por hecho que todos los artesanos en la fábrica son igual de capaces
de fabricar todos los muebles.
- Proceso de fabricación: un artesano, al terminar la fabricación de un mueble, acude al sistema para
ver los próximos trabajos que le tocan. Según la información en el sistema por el pedido actual, tiene
que ponerse con la fabricación de un nuevo mueble y dejar constancia del proceso en el sistema, de
manera que el jefe pueda inspeccionar los progresos de cada artesano y asignar los nuevos pedidos
en consecuencia. Si por el motivo que sea (por ejemplo, falta de piezas), un artesano deja un trabajo
en un estado sin completar, anota el motivo en el sistema y pasa al siguiente trabajo.
- Gestión de usuarios: altas, bajas, modificaciones de las personas que figuran en el sistema, tanto
empleados como clientes.
- Gestión de clientes por parte del comercial: comunicar a los clientes el precio de un pedido,
informarles de que su pedido está listo para recoger/entregar, etc.
Para estructurar los datos en el sistema se contemplarán dos jerarquías de objetos:
- Mueble con dos subtipos:
**Mesa** con sus subtipos: _mesa de café_ con dos subtipos (_mesa de café de cristal_ y _mesa de
café de madera_), _mesa de dormitorio_ y _mesa de comedor_.
**Silla** con sus subtipos (_silla de cocina_, _silla de oficina_ con dos subtipos (_silla de oficina con
ruedas_ y _silla de oficina sin ruedas_) y _silla plegable_).
- Persona con dos subtipos:
**Empleado** con sus subtipos: _jefe_, _comercial_ y _artesano_ con dos subtipos (_contrato por hora
y en plantilla_).
**Cliente** con sus subtipos: _persona_ y _empresa_.
En estas dos jerarquías se contemplan un total de 23 tipos de objetos, los cuales deben estar explícitamente
representados, cada uno en su clase particular.
#Desarrollo de la práctica
En esta práctica se propondrán diferentes funcionalidades en función de la calificación a la que aspire el
estudiante. De este modo, una mayor complejidad a desarrollar implicará una calificación mayor en la
evaluación de la práctica. Hay que tener en cuenta que la nota mínima para aprobar la práctica es 5.0.
Es importante considerar que para optar a la calificación de un nivel superior han de cumplirse todas y cada
una de las funcionalidades especificadas en el nivel inmediatamente anterior. Caso de no ser así (no cumplir
con todos los requerimientos de un nivel), no se podrá obtener una calificación superior a la marcada por el
nivel cuyas restricciones no se cumplen en su totalidad. Del mismo modo, los niveles han de implementarse
en el orden que se indican, no siendo posible implementar niveles no consecutivos para obtener
calificaciones superiores.

Para cada uno de los niveles se van a indicar unos requisitos mínimos de cumplimiento. Esto quiere decir
que para cualquier otro detalle de diseño que no se encuentre descrito expresamente en lo indicado en este
enunciado, el alumno tiene libertad para tomar cuantas decisiones considere oportunas.
Para obtener la nota mínima para aprobar hay que desarrollar los primeros dos niveles de la práctica.
### Nivel 1 - Puntuación total máxima a obtener: 3 puntos.
Lo que se pretende que el alumno desarrolle en este nivel son las relaciones de clase, herencia y demás que
van asociadas al desarrollo de la práctica. Así, se pide realizar las siguientes tareas:
- Planteamiento del problema: actores participantes, relaciones entre actores, funcionalidad a cumplir por
la práctica a desarrollar.
- Establecimiento de diferentes clases a intervenir en la práctica, relaciones de dependencia entre clases,
identificar diferentes jerarquías de clases, etc.
- Elaboración de un documento escrito (memoria de la práctica) que contenga el primer punto y los
correspondientes ficheros para BlueJ que implementen el segundo.
Es necesario contemplar dos jerarquías de herencia que incluyan las características necesarias para poder
diferenciar su posición en cada jerarquía: una para los muebles y otra para las personas.
### Nivel 2 - Puntuación total máxima a obtener: 7 puntos.  
Los alumnos que implementen este nivel de finalización de la práctica recibirán una puntuación máxima de
7 puntos. Sólo se podrá optar a este Nivel si se ha implementado satisfactoriamente y en su totalidad los
requerimientos especificados en el Nivel 1. Lo que se pretende que el alumno desarrolle en este nivel es la
parte de gestión de datos del sistema de la fabrica usando una estructura de clases y métodos apropiados.
De este modo, el sistema deberá permitir lo siguiente:
- Añadir nuevos muebles al sistema y actualizar los datos de muebles ya en el sistema.
- Dar de alta a empleados y clientes en el sistema con sus datos personales.
- Dar de alta un nuevo pedido de muebles con los datos del cliente correspondiente.
- Realizar búsquedas sencillas sobre los empleados, clientes y pedidos.
### Nivel 3 - Puntuación total máxima a obtener: 10 puntos.  
Los alumnos que implementen este nivel de finalización de la práctica recibirán una puntuación máxima de
10 puntos. Sólo se podrá optar a este Nivel si se han implementado satisfactoriamente y en su totalidad los
requerimientos especificados en el Nivel 2. Lo que se pretende es que el alumno desarrolle en este nivel la
interfaz textual del sistema para las funciones identificadas en el nivel 2 más la gestión de artesanos y el
proceso de fabricación de los muebles. De este modo, el sistema deberá permitir lo siguiente:
- Gestionar las funciones identificadas en el nivel 2.
- Permitir la asignación de las fichas de los empleados, clientes y pedidos.
- Permitir que cada artesano vea las fichas que le toca gestionar y pueda editar los datos dejando
constancia del trabajo realizado y el estado de fabricación (por ejemplo, pendiente, en proceso, parado
[hace falta piezas, pendiente de confirmación del cliente], fase de prueba, terminado).
- Producir diferentes listados del funcionamiento de la fabrica: las piezas que hace falta pedir para las
fabricaciones, las fichas procesadas por cada artesano, las confirmaciones que hay que solicitar a los
clientes, las fichas en proceso y un historial de cada artesano y cada mueble.
