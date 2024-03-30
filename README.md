# UniqueTriplets

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) installed on your machine.
- Maven installed on your machine.
- Postman (or any API testing tool) installed for testing the API endpoints.
- 

#The application should now be running on `http://localhost:8080/uniques`.

## Usage

### API Endpoint

- **Endpoint**: `/uniques`
- **HTTP Method**: `POST`
- **Request Body**: JSON object with two fields:
- `nums`: An array of integers.
- `target`: The target integer value.

Example Request Body:
```json
{
 "nums": [1, 2, 3, 4, 5],
 "target": 9
}
