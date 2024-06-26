API RESTful sencilla para gestionar un sistema de biblioteca. Tendremos dos entidades: `Book` y `Author`.
 
### Entidades y Atributos
 
#### 1. Entidad `Book`:
- `id` (Long): Identificador único del libro.
- `title` (String): Título del libro.
- `isbn` (String): Código ISBN del libro.
- `publishedDate` (Date): Fecha de publicación del libro.
- `authorId` (Long): Identificador del autor del libro.
 
#### 2. Entidad `Author`:
- `id` (Long): Identificador único del autor.
- `name` (String): Nombre del autor.
- `birthdate` (Date): Fecha de nacimiento del autor.
- `country` (String): País de origen del autor.
 
### Endpoints del API
 
#### Endpoints para `Book`:
1. **GET /api/books**: Obtener todos los libros.
2. **GET /api/books/{id}**: Obtener un libro por su ID.
3. **POST /api/books**: Crear un nuevo libro.
4. **PUT /api/books/{id}**: Actualizar un libro existente.
5. **DELETE /api/books/{id}**: Eliminar un libro por su ID.
 
#### Endpoints para `Author`:
1. **GET /api/authors**: Obtener todos los autores.
2. **GET /api/authors/{id}**: Obtener un autor por su ID.
3. **POST /api/authors**: Crear un nuevo autor.
4. **PUT /api/authors/{id}**: Actualizar un autor existente.
5. **DELETE /api/authors/{id}**: Eliminar un autor por su ID.
