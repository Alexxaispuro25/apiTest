API de Gestión de Productos
Este proyecto es una API RESTful desarrollada en Java utilizando el framework Spring Boot. Proporciona operaciones CRUD (Crear, Leer, Actualizar, Borrar) para gestionar productos
con el uso de tecnologías como Jpa y Hibernate en una base de datos MySql y Swagger para la documentación de la api.

Características
Agregar Producto: Permite agregar un nuevo producto a la base de datos.
Agregar Varios Productos: Permite agregar una lista de productos a la base de datos.
Obtener Todos los Productos: Obtiene todos los productos almacenados en la base de datos.
Obtener Producto por ID: Obtiene un producto específico por su ID.
Obtener Producto por Nombre: Obtiene un producto por su nombre.
Actualizar Producto: Actualiza la información de un producto existente en base al id que le mandes.
Borrar Producto: Elimina un producto de la base de datos por su ID.



Configuración
Clona este repositorio en tu máquina local.
Luego abre o importa la carpeta spring-boot-app con su idle de preferencia en nuestro caso se uso IntelliJ.

Configura una base de datos MySQL y actualiza las credenciales en el archivo application.properties.
Para crear la base de datos utilizada en este proyecto corra la siguiente instrucción en un Script File de MySql:
CREATE DATABASE IF NOT EXISTS produ;
USE produ;

o modificar la instrucción  spring.datasource.url del archivo application.properties para apuntar a una base de datos ya creada o diferente.


Ejecuta la aplicación utilizando Gradle para el manejo de dependencias(build.gradle).
Accede a la documentación de la API en http://localhost:8080/swagger-ui/index.html
ya que se encuentre la api corriendo en el entorno local.



Ejemplo de consumo de los endpoints:
Método: POST
Endpoint con url completa: http://localhost:8080/api/agregarProducto
Body:
{
    "nombre":"Pera",
    "descripcion":"a",
    "precio":5,
    "cantidad":2
}

Para ver todos los productos:
Método: GET
Url: http://localhost:8080/api/producto/
