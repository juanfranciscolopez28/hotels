# Hotels CRUD

Aplicación Rest con métodos CRUD y BBDD en memoria.

  - Frameworks: Spring, FlyWay
  - BBDD: H2
  - URL base : http://localhost:8080

# Endpoints

  - GET /hotels/ - Listar todos
  - GET /hotels/{id} - Listar por ID
  - POST /hotels - Insertar hotel
```json
{
	"name": "Barceló",
	"rooms": 85,
	"location": {
		"code": "PMI"
	}
}
```
  - PUT /hotels/{id} - Actualizar hotel
```json
{
	"name": "Barceló Hoteles",
	"rooms": 90,
	"location": {
		"code": "BCN"
	}
}
```
  - DELETE /hotels/{id} - Eliminar hotel