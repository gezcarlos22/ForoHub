# 🚀 ForoHub - API REST de Plataforma de Foros

ForoHub es una **API REST moderna** desarrollada con **Java 17+** y **Spring Boot**, diseñada para gestionar usuarios, tópicos y respuestas en un entorno de foro en línea de forma **segura, escalable y eficiente**.  
Implementa un sistema robusto de **autenticación y autorización con Spring Security y JWT**, garantizando que solo los usuarios autenticados puedan interactuar con los recursos.

---

## ✨ Descripción del Proyecto

- **CRUD completo** para Usuarios, Tópicos y Respuestas.  
- **Autenticación JWT** para sesiones sin estado.  
- **Arquitectura RESTful** con validación estricta.  
- Persistencia en **MySQL/MariaDB** con migraciones gestionadas por **Flyway**.  
- Integración sencilla y lista para producción.

---

## 🌟 Tecnologías Utilizadas

| Componente                    | Función |
|--------------------------------|---------|
| **Java 17+**                   | Lenguaje principal |
| **Spring Boot**                | Framework backend |
| **Spring Data JPA**            | Interacción ORM |
| **Spring Security**            | Autenticación y autorización |
| **JWT (JSON Web Tokens)**      | Autenticación sin estado |
| **MySQL / MariaDB**            | Base de datos relacional |
| **Flyway**                     | Migraciones de BD |
| **Maven**                      | Gestión de dependencias |
| **Lombok**                     | Reducción de código boilerplate |
| **Jakarta Bean Validation**    | Validación de datos de entrada |

---

## 🚀 Funcionalidades Principales

### 👥 Gestión de Usuarios
- **Registro** de nuevas cuentas.  
- **Login** para obtener un token JWT.  
- **Listar** todos los usuarios (paginación y ordenamiento).  
- **Buscar** por ID u otros criterios.  
- **Actualizar** información.  
- **Eliminar** usuarios.

### 💬 Gestión de Tópicos (CRUD)
- **Crear** nuevos temas de discusión.  
- **Listar** todos los tópicos (paginación y ordenamiento).  
- **Buscar** por ID u otros criterios.  
- **Actualizar** contenido.  
- **Eliminar** tópicos.

### 💭 Gestión de Respuestas (CRUD)
- **Crear** respuestas en los tópicos.  
- **Listar** todas las respuestas (paginación y ordenamiento).  
- **Buscar** por ID u otros criterios.  
- **Actualizar** contenido.  
- **Eliminar** respuestas.

---

## 📦 Requisitos

- **JDK 17+**  
- **Maven**  
- **MySQL 8+** o **MariaDB**  
- Cliente REST (Postman, Insomnia, etc.)

---

## 🛠️ Instalación y Configuración

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/api-forohub.git
   cd api-forohub
   ```

2. **Configurar la base de datos** en `application.properties`
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/forohub
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_password
   ```

3. **Construir el proyecto**
   ```bash
   mvn clean install
   ```

4. **Ejecutar la aplicación**
   ```bash
   mvn spring-boot:run
   ```
   Por defecto en: `http://localhost:8080`

---

## ⚙️ Uso Básico de la API

### 1️⃣ Registrar un usuario
**POST** `/usuarios/registrar`
```json
{
  "nombre": "usuario",
  "email": "usuario@example.com",
  "password": "password_segura"
}
```

### 2️⃣ Iniciar sesión y obtener token JWT
**POST** `/usuarios/login`
```json
{
  "email": "usuario@example.com",
  "password": "password_segura"
}
```
**Respuesta:**
```json
{
  "token": "JWT_GENERADO"
}
```

## 🤝 Contribución
¡Las contribuciones son bienvenidas!  
Si encuentras errores o tienes mejoras, abre un **issue** o envía un **pull request**.




