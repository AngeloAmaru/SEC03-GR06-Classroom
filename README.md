
# EduTech - Arquitectura de Microservicios

EduTech es una plataforma educativa implementada con una arquitectura de microservicios desacoplados, usando Spring Boot, Eureka, OpenFeign, Swagger/OpenAPI, HATEOAS, JPA y MySQL. El proyecto está preparado para escalar, mantener y probar de forma robusta cada microservicio.

## Estructura del Proyecto

- **eureka/**: Servidor Eureka para descubrimiento de servicios.
- **ms-users/**: Microservicio de usuarios.
- **ms-courses/**: Microservicio de cursos (CRUD, mappers manuales, pruebas unificadas).
- **ms-grades/**: Microservicio de notas y matrículas (Enrollment), con pruebas CRUD y mappers manuales.
- **ms-payments/**: Microservicio de pagos y cupones de descuento, con pruebas CRUD y mappers manuales.
- **ms-support/**: Microservicio de soporte.
- **common/**: Librería compartida (DTOs, excepciones, utilidades).
- **Scripts globales**: `run-all.bat`, `compile.bat`, `install.bat`, `run-*.bat` para facilitar la gestión y despliegue.

## Tecnologías y Buenas Prácticas

- Spring Boot, Spring Data JPA, Spring Cloud Eureka, OpenFeign, Swagger/SpringDoc, Spring HATEOAS, Lombok, JUnit/Mockito, MySQL.
- **Mappers manuales**: Todos los microservicios usan mappers implementados manualmente (sin MapStruct), facilitando el control y la mantenibilidad.
- **Pruebas unitarias CRUD**: Estructura unificada de pruebas para entidades y servicios en ms-courses, ms-grades y ms-payments, cubriendo todos los métodos CRUD y casos relevantes.
- **Mocks y dependencias**: Uso de Mockito para simular dependencias externas (por ejemplo, UserClient en ms-payments).
- **Cobertura de pruebas**: Todos los microservicios principales cuentan con pruebas unitarias ejecutables y validadas.
- **Comunicación**: Feign y Eureka para integración entre microservicios.
- **Documentación OpenAPI/Swagger**: Accesible en cada microservicio.
- **HATEOAS**: Respuestas enriquecidas para facilitar la navegación RESTful.

## Ejecución y Pruebas

### 1. Pre-requisitos
- Java 17+
- Maven 3.8+
- MySQL (con la base de datos `edutech` creada)

### 2. Configuración de la base de datos
- Asegúrate de tener MySQL corriendo y la base de datos `edutech` creada.
- Usa el script `create-db.sql` incluido para crear la estructura inicial.

### 3. Compilación y despliegue
- Desde la raíz del proyecto:
  ```cmd
  compile.bat
  ```
- O manualmente:
  ```cmd
  mvn clean install
  ```

### 4. Instalación de dependencias
- Ejecuta `install.bat` en la raíz o en cada microservicio para instalar dependencias locales.

### 5. Ejecución de servicios
- Inicia Eureka:
  ```cmd
  cd eureka && run.bat
  ```
- Inicia todos los microservicios con:
  ```cmd
  run-all.bat
  ```
- O individualmente:
  ```cmd
  cd ms-courses && run.bat
  cd ms-grades && run.bat
  cd ms-payments && run.bat
  cd ms-users && run.bat
  cd ms-support && run.bat
  ```

### 6. Verificación y documentación
- Accede a [http://localhost:8761](http://localhost:8761) para ver el panel de Eureka.
- Documentación Swagger de cada microservicio:
  - Usuarios: [http://localhost:9001/swagger-ui.html](http://localhost:9001/swagger-ui.html)
  - Cursos: [http://localhost:9002/swagger-ui.html](http://localhost:9002/swagger-ui.html)
  - Notas: [http://localhost:9003/swagger-ui.html](http://localhost:9003/swagger-ui.html)
  - Soporte: [http://localhost:9004/swagger-ui.html](http://localhost:9004/swagger-ui.html)
  - Pagos: [http://localhost:9005/swagger-ui.html](http://localhost:9005/swagger-ui.html)

### 7. Pruebas automáticas
- Ejecuta todas las pruebas unitarias desde la raíz:
  ```cmd
  mvn test
  ```
- O por microservicio:
  ```cmd
  cd ms-courses && mvn test
  cd ms-grades && mvn test
  cd ms-payments && mvn test
  ```
- Las pruebas cubren entidades, servicios y mappers, siguiendo un patrón unificado y validando la lógica CRUD y de negocio.

### 8. Pruebas manuales
- Usa Postman y la colección incluida (`Edutech.postman_collection.json`) para probar los endpoints.

## Notas y Estado Final
- Todos los microservicios principales cuentan con pruebas unitarias validadas y mappers manuales.
- La estructura de carpetas y scripts permite una gestión sencilla y escalable.
- El módulo `common` centraliza DTOs y utilidades compartidas.
- MapStruct ha sido eliminado completamente del proyecto.
- El sistema está listo para escalar, mantener y extender.

---

**Proyecto finalizado y validado: arquitectura robusta, pruebas unificadas y documentación actualizada.**

# Comandos útiles

Compilar sólo el POM del padre:
```cmd
mvn install -N
```

Limpiar carpetas target:
```cmd
mvn clean
```

Eliminar carpeta .m2 (Windows):
```cmd
rmdir /S /Q %USERPROFILE%\.m2
```

