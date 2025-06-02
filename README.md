## 📦 Producto Service

Microservicio REST desarrollado en Java con Spring Boot para gestionar productos. Permite registrar nuevos productos, listarlos, actualizarlos, eliminarlos y aplicar filtros por nombre, marca o categoría. Forma parte de un sistema de ventas modular.

---

## ⚙️ Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- MySQL
- Maven
- MapStruct
- Jakarta Bean Validation
- Postman para pruebas

---

## 🛠️ Entidad principal: `Producto`

Cada producto cuenta con los siguientes atributos:

- `id` (Long): Identificador único (autogenerado)
- `nombre` (String): Nombre del producto
- `descripcion` (String): Descripción del producto
- `marca` (String): Marca del producto
- `categoria` (String): Categoría a la que pertenece
- `stock` (Integer): Cantidad de productos en stock fisico.

---

## 📘 Endpoints disponibles
🔸 Crear producto
POST /producto/registrar

Cuerpo (JSON):
{
  "nombre": "Notebook Lenovo",
  "descripcion": "Notebook 15.6'' Ryzen 5",
  "marca": "Lenovo",
  "categoria": "Tecnología"
}
📌 Si el producto ya existe por nombre y marca, lanza una excepción personalizada.

# 🔸 Listar todos los productos
GET /producto/

Devuelve una lista de todos los productos registrados.

# 🔸 Buscar producto por ID
GET /producto/{id}

Devuelve los datos del producto con el ID indicado. Si no existe, lanza una excepción personalizada.

# 🔸 Actualizar producto por ID
PUT /producto/{id}

Cuerpo (JSON):
{
"nombre": "Notebook Lenovo",
"descripcion": "Notebook actualizada con SSD",
"marca": "Lenovo",
"categoria": "Tecnología"
}

# 🔸 Eliminar producto por ID
DELETE /producto/{id}

Elimina el producto correspondiente al ID. Devuelve un mensaje indicando la eliminación. Si no existe, lanza excepción.

# 🔍 Filtros
Buscar por nombre
GET /producto/nombre/{nombre}

Devuelve un producto por nombre exacto.

Buscar por marca
GET /producto/marca/{marca}

Devuelve una lista de productos filtrados por marca.

Buscar por categoría
GET /producto/categoria/{categoria}

Devuelve una lista de productos filtrados por categoría.

---

# ❗ Validaciones y manejo de errores
El proyecto cuenta con:

Validaciones en DTO usando @NotBlank y @NotNull.

Manejador global de excepciones con:

ProductoYaExisteException

NoExisteProductoBuscadoException

SinProductosException

SinProductosPorMarcaException, etc.

---

## 🗂️ Organización del proyecto
entity: entidad Producto

dto: transferencia de datos

repository: acceso a base de datos

service: lógica de negocio

controller: endpoints REST

exception: excepciones personalizadas

mapper: conversión entre entidad y DTO

---

## ✍️ Autor
Desarrollado por Santiago Landi – Proyecto de práctica sobre microservicios.