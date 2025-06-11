# 📝 Task Management API

API REST para la gestión de tareas desarrollada con Spring Boot. Permite registrar usuarios, autenticarse mediante JWT y administrar tareas personales.

## 🚀 Tecnologías

- Java 17
- Spring Boot 3
- Spring Security (JWT)
- Spring Data JPA
- H2 (Base de datos en memoria)
- Swagger/OpenAPI
- Lombok

## 📦 Requisitos previos

- Java 17 o superior
- Maven 3.8+


## ⚙️ Instalación y ejecución local

1. **Clonar el repositorio:**

```bash
git clone https://github.com/tuusuario/task-management.git
cd task-management
```
## ▶️ Paso 1: Ejecutar la aplicación localmente
Opción A: Usando Maven
```bash
mvn spring-boot:run
```

Opción B: Usando el archivo .jar generado
```bash
mvn clean install
```
Luego ejecuta:
```bash
java -jar target/task-management-0.0.1-SNAPSHOT.jar

```


## 📘 Documentación de la API

La documentación completa y navegable de esta API se encuentra disponible a través de **Swagger UI**, donde podrás visualizar, probar y consumir todos los endpoints disponibles con facilidad.

| 🔍 Recurso       | 🌐 URL                                                                                      |
|------------------|---------------------------------------------------------------------------------------------|
| Swagger UI       | [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) |

> 📌 **Nota:** Swagger proporciona una interfaz interactiva donde puedes autenticarte con tu token JWT y realizar pruebas directamente desde el navegador.

🔍 Paso 2: Acceder a la documentación interactiva (Swagger)
Desde Swagger puedes probar los endpoints directamente. Para los protegidos por JWT, sigue este flujo:
## 📝 Flujo de Autenticación

> Ya hay usuarios creados por defecto. Puedes probar con los siguientes datos:

### 👤 Usuarios de prueba

| Usuario | Contraseña |
|---------|------------|
| admin   | admin123  |
| user1   | user123  |


---

### 🔐 Pasos para autenticarte desde Swagger:

1. **Regístrate**  
   Envía una solicitud `POST` a `/auth/users` con los datos del nuevo usuario en formato JSON.

2. **Inicia sesión**  
   Envía una solicitud `POST` a `/auth/session` con las credenciales del usuario.

3. **Copia el token JWT**  
   Una vez autenticado, recibirás un token JWT en la respuesta.

4. **Autoriza en Swagger**  
   Haz clic en el botón de candado **Authorize**, pega el token con el prefijo `Bearer `: antes del token, y haz clic en **Authorize**.
5. **Prueba los endpoints protegidos**  
   Ahora podrás acceder a los endpoints protegidos de la API directamente desde Swagger.



## ✅ Endpoints principales
⚠️ Todos los endpoints (excepto /auth/*) requieren token JWT en la cabecera:


| Método | Endpoint     | Descripción            |
| ------ |--------------| ---------------------- |
| POST   | `/auth/users`     | Registro de usuario    |
| POST   | `/auth/session` | Inicio de sesión y JWT |

## 📋 Endpoints de Tareas (protegidos)

| Método | Endpoint          | Descripción               |
| ------ |-------------------| ------------------------- |
| GET    | `/api/tasks`      | Listar tareas del usuario |
| GET    | `/api/tasks/{id}` | Obtener tarea por ID      |
| POST   | `/api/tasks`      | Crear nueva tarea         |
| PUT    | `/api/tasks/{id}` | Actualizar tarea          |
| DELETE | `/api/tasks/{id}` | Eliminar tarea            |

## 📫 Colección de Postman

Para realizar pruebas rápidamente, puedes importar esta colección en Postman:

📥 [Descargar colección Postman](./postman/TestTecnova.postman_collection.json)

### 🔧 ¿Cómo importar?

1. Abre Postman.
2. Haz clic en "Import" (esquina superior izquierda).
3. Selecciona "File" y carga el archivo `TestTecnova.postman_collection.json`, o elige "Raw text" y pega el contenido.
4. ¡Listo! Ya puedes probar los endpoints.


## 👨‍💻 Autor
### Erwin Soto 
#### 📧 Contacto: https://www.linkedin.com/in/dubhan-soto/
💬 ¡Gracias!
