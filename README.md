# Poseidon 
This is a part of the app, which aims to generate more transactions for institutional investors who buy and sell fixed income securities.
This app works with Java Spring and stores data in MySQL.

## Composing

### DataBase
The MySQL database is permanent, it is generated automatically via Spring boot in the `demo` shema.

You can modify the path to the database in `application.properties`, for example to use `prod` instead of the custom shema.
But also to modify the username and password, root and rootroot.

A demonstration script to run in the shema is also available.

### APPLICATION
The application is composed of html page allowing various actions and displaying corresponding information.

1. `Home`
  * Available with a simple `/`.
  * Gives access to Login and user management.
  * 
2. `Login`
  * Contains classic login and login by GitHub.
  * The classic connection requires the username and the user password, this one must have an upper case, a lower case, a number, a special character and be at least 8 characters long.
  
3. `bidList` & `curvePoint` & `rating` & `ruleName` & `trade` & `user`

Each of its "links" contains 3 visible and 2 hidden subcategories:
  
  * `list`: Displays a table containing all the entities, an edit and delete button for each of them. Above the table an add button.
  * `add`: Displays a form for adding the entity, the fields to be filled in correspond to the attribute.
  * `update`: Displays an entity update form, the fields to fill out correspond to the attribute to modify. (often identical to Add)
---
  * `validate`: Check that the entered fields correspond to what is expected from the attribute side. (not visible to the user)
  * `delete`: Delete the selected entity, is not visible directly but indirectly from the list where the entity no longer exists.
  

## Launch
Application uses spring boot, use the following command to start it:
`./mvnw.cmd spring-boot:run`

### First Launch
During the first launch it will be necessary to create the `paymybuddy` schema or to have modified it in `application.properties`, 
and as mentioned previously to have in mySQL `root` identifier and `rootroot` password or to have also modify them in the same file.

Then do the `./mvnw.cmd spring-boot:run` command.

And finally in the Authorities array, added the id `1` with the name `User`.

### Demo
Just use `Demo` to the same folder as this ReadMe in mySQL.

The script will create the shema, the database and fill it, if you have changed the shema in `application.properties`, you must modify the first two lines of the script.

And finally launch the application with `./mvnw.cmd spring-boot:run`.

### Connection to the Demo
The Demonstration account:

Username : demo

Password : Demonstration1*

2 other accounts exist, but no password was provided in the file.

## Testing
This project has Units tests written.
It is possible to have access to Surefire Report and Jacoco to visualize the execution time and the coverage of the tests following this path:
`Poseiden-skeleton/target/site/project-reports.html`

### Test Report

After using the following command in the terminal:
`mvn clean verify site`

To access the report without the integration tests:
`mvn clean test site`
