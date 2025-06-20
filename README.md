# Country Services
Spring Boot microservice fetch detailed  information about countries using "https://restcountries.com/v3.1/alpha/{code}"

# Features

- `GET /countries/{code}` – Fetch country information using a 2-letter ISO code (e.g. `US`, `DE`)
- Calls [https://restcountries.com/v3.1/alpha/{code}]
- Transforms API response to custom structure
- sample response
- {
  "countryCode": "US",
  "name": "United States of America",
  "capital": "Washington, D.C.",
  "region": "Americas",
  "currencies": ["USD"],
  "languages": ["English"],
  "borders": ["CAN", "MEX"],
  "sizeCategory": "LARGE"
}
# Bussiness logic
- population determine by size category
 # Erro handling
• 400 for invalid code format
• 404 if country not found
• 502 for upstream API failures

# Project structure
src/
├── controller/
├── service/
├── model/
└── exception/

# Tech Stack
- Java 17
- Spring Boot 3.x
- Maven

  # build the project
  mvn clean install

  # run the application
 mvn spring-boot:run

  # Screen will start at
  http://localhost:8080

 # test the API
  http://localhost:8080/countries/US
