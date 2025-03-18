# POC for Spring Web + Spring Security

User input is not being validated, but could be done using parameters annotation with `Jakarta Validation` and `Hibernate Validator`.</br>
This project doesn't allow customization for visited places added by the user, and is used as a proof of concept of implementing `Spring Web` and `Spring Security`, while providing a `REST`
endpoint to save and retrieve data using `Spring Data JPA`.</br>

`ResponseEntityExceptionHandler` is being used to handle errors globally.

## `POST` /register
Requires JSON:
```JSON
{
  "username": "john_doe",
  "password": "securePassword123"
}
```
Password encrypted with `BCryptPasswordEncoder`.

## `POST` /places/{cep}
Saves a new `Place` for the logged-in user using the ViaCep API to retrieve the address with a CEP.<br/>
Example request: `/places/12345678`.

## `GET` /places

Retrieves logged-in user visited places.

## Location API
Users should use HTTP basic to register visited locations and retrieve user data.

## Postman tests
[spring.location.api.postman_collection.json](__postman__/spring.location.api.postman_collection.json)