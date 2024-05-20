## Recipe API

This project provides a Spring Boot powered REST API for managing recipes.

**Features:**

- CRUD operations on recipes:
  - Create new recipes
  - Get all recipes
  - Get a recipe by ID
  - Update an existing recipe
  - Delete a recipe

**Technologies Used:**

- Spring Boot
- Spring MVC

**Dependencies:**

- Spring Web
- (Add any other relevant dependencies here)

**Setup:**

1. **Clone the repository:**

```
git clone https://github.com/Ashwin-Ash-09/recipeapi
```

2. **Install dependencies:**

```
mvn install
```

3. **Configure database connection :**

   - Edit application properties file (e.g., `src/main/resources/application.properties`) to configure your database connection details.

**Running the application:**

1. **Start the application:**

```
mvn spring-boot:run
```

**API Endpoints:**

| Method | URI             | Description                  |
| ------ | --------------- | ---------------------------- |
| GET    | `/recipes`      | Retrieves all recipes        |
| GET    | `/recipes/{id}` | Retrieves a recipe by its ID |
| POST   | `/recipes`      | Creates a new recipe         |
| PUT    | `/recipes/{id}` | Updates an existing recipe   |
| DELETE | `/recipes/{id}` | Deletes a recipe             |

**Request Body Format (POST and PUT):**

The request body should be a JSON object representing the recipe data. Here's an example structure:

```json
{
	"recipe": {
		"recipeID": 2,
		"name": "Double Chocolate Fudge Cake",
		"description": "A rich and decadent chocolate cake with a smooth ganache frosting.",
		"steps": "1. Preheat oven to 350°F (175°C). 2. Cream butter and sugar together.
         3. Add eggs one at a time, then mix in dry ingredients. 4. Pour batter into greased pan and bake for 30-35 minutes. 
         5. While cake cools, prepare ganache by heating cream and pouring it over chocolate. 6. Frost cake once cool."
	}
}
```

**Response Codes:**

- 200 OK - The request was successful
- 400 Bad Request - The request was invalid
- 404 Not Found - The requested resource was not found
- 405 Not Found - The method not allowed

**Example Usage:**

**Get all recipes:**

```bash
curl http://localhost:8080/recipes
```

**Create a new recipe:**

```bash
curl -X POST -H "Content-Type: application/json" -d '{ "name": "My Recipe", "description": "This is a delicious recipe" }' http://localhost:8080/recipes
```

**Get a recipe by ID:**

```bash
curl http://localhost:8080/recipes/1
```

**Update a recipe:**

```bash
curl -X PUT -H "Content-Type: application/json" -d '{ "name": "Updated Recipe", "description": "This recipe has been updated" }' http://localhost:8080/recipes/1
```

**Delete a recipe:**

```bash
curl -X DELETE http://localhost:8080/recipes/1
```

**Additional Notes:**

- This is a basic example and may require customization for specific needs.
- Error handling is omitted for brevity. Consider implementing proper error handling for a production environment.
- Security considerations are not addressed in this example. For a production deployment, implement security measures to protect your API.
