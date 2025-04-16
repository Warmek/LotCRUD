# Passenger CRUD
This project aims to create a simple REST api for managing tickets for an airport, build with Spring Boot.

## Installation
### Prerequisites
- Java 17
- Setup email at: [Link](https://myaccount.google.com/apppasswords)
### Installation
- Clone repository with git
```bash
git clone https://github.com/Warmek/LotCRUD.git
```
- Run the project
For windows:
```shell
mvnw.cmd clean spring-boot:run
```
For Linux:
```bash
./mvnw clean spring-boot:run
```

## Usage
### Create:
- Passenger
```bash
curl -X POST localhost:8080/passengers -H 'Content-type:application/json' -d '{"firstName": "John", "lastName": "Doe", "email": "jd@gmail.com", "phoneNumber": "000000000"}'
```
- Flight
```bash
curl -X POST localhost:8080/flights -H 'Content-type:application/json' -d '{"origin": "startPlace", "destination": "targetPlace", "flightTime": 90, "oneWay": true}'
```
- Reservation
```bash
curl -X POST localhost:8080/reservations -H 'Content-type:application/json' -d '{"flightNumber": 1, "passengerNumber": 1, "didTakeoff": true, "seatNumber": 1}'
```
### Read:
- Passenger
```bash
curl localhost:8080/passengers
```
- Flight
```bash
curl localhost:8080/flights
```
- Reservation
```bash
curl localhost:8080/reservations
```

### Update
- Passenger
```bash
curl -X PUT localhost:8080/passengers/1 -H 'Content-type:application/json' -d '{"firstName":"John","lastName":"Doe","email":"jd@gmail.com","phoneNumber":"000000000"}'
```
- Flight
```bash
curl -X PUT localhost:8080/flights/1 -H 'Content-type:application/json' -d '{"origin":"startPlace","destination":"targetPlace","flightTime":90,"oneWay":true,"seatNumber":2}'
```
- Reservation
```bash
curl -X PUT localhost:8080/reservations/1 -H 'Content-type:application/json' -d '{"flightNumber":1,"seatNumber":1,"passengerId":1,"passangerName":"John","passangerLastName":"Doe","passangerEmail":"jd@gmail.com","passangerPhoneNumber":"000000000","didTakeoff":true}'
```

### Delete
- Passenger
```bash
curl -X DELETE localhost:8080/passengers/1
```
- Flight
```bash
curl -X DELETE localhost:8080/flights/1
```
- Reservation
```bash
curl -X DELETE localhost:8080/reservations/1
```
## For potential improvments to the project, look at: 
[my commentary](mycomment.md)
