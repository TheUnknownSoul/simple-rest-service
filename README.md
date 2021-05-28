# simple-rest-service

Rest service that uses JpaRepository function for working with data.

Realize endpoints as:

`GET /someCollection`

`GET /someCollection/{id}`

`POST /someCollection`

`PUT /someCollection/{id}`

`PATCH /someCollection/{id}`

`HEAD /someCollection/{id}`

`DELETE /someCollection/{id}`

In some `collection`s mean the simple collection of Users.

### Uses
- Spring Boot;
- h2 database (in memory mode);
- Apache Common lang3 (String Utils);
- lombok;