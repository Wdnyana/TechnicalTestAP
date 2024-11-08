# Recruitment API

## Goal

Build a simple backend API for a recruitment application where admins can post job vacancies and retrieve only active vacancies (vacancies that have not expired). The expiration date will be automatically set by the system.

## Challenge

1. **Create**: Admins can add new job postings with details such as title, description, requirements, and deadline.
2. **Read**: Candidates can view all active job postings, while admins can view all job postings.
3. **Update**: Admins can edit job postings, including the option to repost a vacancy so it does not expire.
4. **Delete**: Admins can remove job postings.

## Solution

### Technologies Used
- **Java**: The backend API is built with Java using the **Spring Boot** framework.
- **MongoDB**: Used as the NoSQL database to store job vacancies data.
- **Postman**: Used for API documentation and testing.
- **GitHub**: Version control and project collaboration.

### Step-by-Step Solution

1. **API Development**:
   - **Spring Boot** was used to quickly set up the backend structure and expose the RESTful API endpoints for managing job vacancies.
   - **MongoDB** was chosen for storing job vacancies because of its flexibility and ease of handling dynamic data structures.

2. **Database Design**:
   The following fields are stored in the `db_vacancy` collection:
   - **Vacancy**: The type of the job posting.
   - **Vacancy Name**: The title of the job posting.
   - **Description**: The detailed description of the job.
   - **Maximum Age**: The maximum age allowed for candidates (if applicable).
   - **Minimum Experience**: The minimum required experience for the job.
   - **Salary**: The salary offered for the job position.
   - **Publish Date**: The date when the job was published.
   - **Expiry Date**: The date when the job posting will expire. This is automatically calculated based on a predefined expiration time from the publish date.

3. **Business Logic**:
   - **Create Vacancy**: Admins can create new job postings by sending a POST request with vacancy details. The expiration date is automatically set based on the publish date.
   - **View Active Vacancies**: active vacancies can be taken by admin by sending a GET request to `/api/vacancy/active`.
   - **Update Vacancy**: Admins can update existing vacancies.
   - **Delete Vacancy**: Admins can delete job postings using the DELETE endpoint.

4. **API Endpoints**:
   - `POST /api/vacancy`: Create a new job vacancy.
   - `GET /api/vacancy/gets`: Get all job vacancies (candidates can view).
   - `GET /api/vacancy/{id}`: Get vacancy by id.
   - `GET /api/vacancies/active`: Get all active job vacancies.
   - `PUT /api/vacancy/update/{id}`: Update a job vacancy.
   - `DELETE /api/vacancy/delete/{id}`: Delete a job vacancy.

5. **Postman Collection**:
   The API documentation and testing have been provided via **Postman**. You can import the collection into your Postman app to test the API endpoints.

   - To import the collection, download the `` file and import it into Postman.

6. **API Documentation**:
   API endpoints are thoroughly documented using Postman. The collection includes request methods, body examples, and expected responses for all the CRUD operations.

### Clone the Repository
1. clone project: ```https://github.com/Wdnyana/TechnicalTestAP.git```
2. go to project path: ```cd recruitment-api```
3. and finally you can running the project.

