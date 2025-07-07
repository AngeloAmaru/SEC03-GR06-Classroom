# EduTech - Arquitectura de Microservicios

Este proyecto implementa EduTech usando una arquitectura de microservicios basada en Spring Boot, Eureka, OpenFeign, Swagger/OpenAPI, HATEOAS, JPA y MySQL.

## Estructura del Proyecto

- **eureka/**: Servidor Eureka para descubrimiento de servicios.
- **ms-users/**: Microservicio de usuarios.
- **ms-courses/**: Microservicio de cursos.
- **ms-grades/**: Microservicio de notas.
- **ms-payments/**: Microservicio de pagos.
- **ms-support/**: Microservicio de soporte.
- **common/**: Librería compartida (DTOs, excepciones, utilidades).

## Tecnologías Principales
- Spring Boot, Spring Data JPA, Spring Cloud Eureka, OpenFeign, Swagger/SpringDoc, Spring HATEOAS, Lombok, JUnit/Mockito, MySQL.

## Pasos para Ejecutar el Sistema

1. **Pre-requisitos**
   - Java 17+
   - Maven 3.8+
   - MySQL (con la base de datos `edutech` creada)

2. **Configura la base de datos**
   - Asegúrate de tener MySQL corriendo y la base de datos `edutech` creada.
   - Puedes usar el script `create-db.sql` incluido.

3. **Compila todos los módulos**
   - Desde la raíz del proyecto:
     ```bash
     mvn clean install
     ```

4. **Inicia el servidor Eureka**
   - Ve a la carpeta `eureka` y ejecuta:
     ```bash
     ./run.bat
     # o
     mvn spring-boot:run
     ```
   - Accede a [http://localhost:8761](http://localhost:8761) para ver el panel de Eureka.

5. **Inicia los microservicios**
   - Cada microservicio tiene su propio script `run.bat` o puedes usar:
     ```bash
     cd ms-users && ./run.bat
     cd ms-courses && ./run.bat
     cd ms-grades && ./run.bat
     cd ms-payments && ./run.bat
     cd ms-support && ./run.bat
     ```
   - O usa los scripts globales como `run-all.bat` si están configurados.

6. **Verifica el registro en Eureka**
   - Todos los microservicios deben aparecer en el panel de Eureka.

7. **Accede a la documentación Swagger de cada microservicio**
   - Usuarios: [http://localhost:9001/swagger-ui.html](http://localhost:9001/swagger-ui.html)
   - Cursos: [http://localhost:9002/swagger-ui.html](http://localhost:9002/swagger-ui.html)
   - Notas: [http://localhost:9003/swagger-ui.html](http://localhost:9003/swagger-ui.html)
   - Soporte: [http://localhost:9004/swagger-ui.html](http://localhost:9004/swagger-ui.html)
   - Pagos: [http://localhost:9005/swagger-ui.html](http://localhost:9005/swagger-ui.html)

8. **Prueba los endpoints HATEOAS de ejemplo**
   - Usuarios: `GET /api/users/{id}`
   - Cursos: `GET /api/courses/hateoas-example/{id}`
   - Notas: `GET /api/grades/hateoas-example/{id}`
   - Pagos: `GET /api/payments/hateoas-example/{id}`
   - Soporte: `GET /api/support-tickets/hateoas-example/{id}`

9. **Pruebas automáticas**
   - Ejecuta las pruebas con:
     ```bash
     mvn test
     ```
   - Ejemplo de prueba unitaria en `ms-users` (`UserServiceTest`).

10. **Pruebas manuales**
    - Usa Postman y la colección incluida (`Edutech.postman_collection.json`) para probar los endpoints.

## Notas
- Cada microservicio tiene su propio puerto y nombre.
- Puedes agregar más microservicios siguiendo el mismo patrón.
- Usa el módulo `common` para compartir DTOs y utilidades.
- La comunicación entre microservicios se realiza vía Feign y Eureka.
- Las respuestas pueden ser enriquecidas con HATEOAS para facilitar la navegación RESTful.

---

**¡Listo para escalar y mantener EduTech con microservicios!**

# Comandos

Compilar sólo el POM del padre y nada más:
mvn install -N

Limpiar carpetas target:
mvn clean

Eliminar carpeta .m2
rmdir /S /Q %USERPROFILE%\.m2

