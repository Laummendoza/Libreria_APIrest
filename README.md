# Libreria_APIrest

# Gestión de Librería

Este proyecto es una aplicación backend desarrollada en Java con Spring Boot que permite gestionar una librería.  

## Funcionalidades principales

- Crear nuevas editoriales, libros y autores.  
- Listar editoriales, libros y autores existentes.  
- Modificar datos de editoriales, libros y autores.

## Tecnologías utilizadas

- Java  
- Spring Boot  
- Maven  
 

## Cómo usar este proyecto

1. Clonar el repositorio:  
   ```bash
   git clone <URL-del-repo>
   cd <nombre-del-repo>
   ```

2. Construir y ejecutar la aplicación con Maven:  
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. Probar las APIs usando Postman u otra herramienta similar para hacer peticiones HTTP.  

4. Algunos endpoints disponibles:  
   - `POST /editoriales` para crear una nueva editorial.  
   - `GET /libros` para obtener listado de libros.  
   - `PUT /autores/{id}` para modificar datos de un autor.

## Estructura del proyecto

- `/src/main/java` - Código fuente Java  
- `/src/main/resources` - Recursos y configuraciones  
- `/src/test` - Pruebas unitarias  

## Contacto

Para cualquier consulta o sugerencia, podés contactarme a [tu email o perfil].
