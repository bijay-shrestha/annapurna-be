# annapurna-be

This is the `backend (be)` side of the `Annapurna Rating System` application. The Project is build under the supervision of **Professor Obinna Kalu** from [Maharishi International University](https://miu.edu).

# Problem Statement
For now, there’s no way you that diners can send a feedbacks to MIU Administration regarding the quality of food being served at  MIU Annapurna Dining Halls.

And this is where Annapurna Rating System comes?

# Project Presentation

- [Google Slide Link](https://docs.google.com/presentation/d/e/2PACX-1vT-prp5o0SrX6VJyo3ilNlMvzmXBVDnNrmPTGy2RZUDAu12qeBrdISESRtOdfW5F9DdxE5MLAy3PWzh/pub?start=true&loop=true&delayms=3000)
- All the Project diagrams are inside `documentation` folder of this project.

# API Documentation
By default, the application deploys in Port 8080. The API documentation is maintained with Swagger.
- **Swagger URL:** http://localhost:8080/swagger-ui/index.html#/
- **Postman Collection:** All the API's are maintained as a Postman Collection. Please find the collection file in `0.7-Postman-Collection` directory inside `documentation` folder.
  - **Postman API usage details:** After successfully importing the Postman collection `SWE-Annapurna` by using the provided`.json` file. 
    - First use `POST Login` API
      - There are three valid users with different `Roles` with following user credentials 
        ```
        username: derartu, password: derartu
        username: shelly, password: shelly
        username: bijay, password: bijay```
    - Then you can use any APIs using the provided `access_token`

# SQL Scripts
I used the SQL scripts inside `0.8-Default-SQL-Scripts` to test my APIs but they are not mandatory to execute.
It basically helps you enter the Daily Meal Rating received between `2022-07-13` and `2022-07-14`. _Note: Execute them in the file order._
# Contributors
-  Shelly Neira <img alt="Brazil Flag" src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Brazilian_flag_icon_round.svg/1200px-Brazilian_flag_icon_round.svg.png" width="16" height="16">
-  Derartu Abdisa <img alt="Etheopia Flag" src="https://upload.wikimedia.org/wikipedia/commons/d/de/Flag_of_Ethiopia.jpg" width="16" height="16">
-  Bijay Shrestha <img alt="Nepal Flag" src="https://cdn-icons-png.flaticon.com/512/197/197387.png" width="16" height="16">

