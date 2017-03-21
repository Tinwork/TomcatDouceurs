# TomcatDouceurs

TomcatDouceus is a school project. The J2EE is an app that shorten url that user input. Just like bitly.

# Requirements 

* Tomcat (via docker or not-
* A MySQL database 
* Java install (obviously...)
* Servlet-api lib [Servlet API](https://mvnrepository.com/artifact/javax.servlet/servlet-api/3.0.1)
* JDBC adaptator [JDBC driver](https://dev.mysql.com/downloads/connector/j/5.1.html)
* Intelij IDE 

# Install 

* Clone this repository 
* Make sure that you have the following link with you
* In the project settings add the **JDBC Adaptor** and the **Serlvet-API** as the dependencies of the project
* Change the output path to the one which point to you **WEB-INF/classes** folder 
* Change your **database settings** 

# Docker (in progress...)

* Use a dockerfile (insert the link)
* Create an image using the command **docker build -t tag path_to_dockerfile**
* Boot up your docker with the compose-up command 
* The server should be available on the port 8080

# Contributors 

Tinwork 
