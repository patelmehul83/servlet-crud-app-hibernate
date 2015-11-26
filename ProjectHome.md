This is a web application and can only run on a browser
This app performs all the CRUD Operations on a database table.
The database connection is with Hibernate
How to run
1)Just install a tomcat server which has java and servlet container
2)Place this in web apps of tomcat you installed
3)Run the server (cmd>travel to tomcat/bun>catalina.bat run)
4)If you want to do any changes do them.
but you have to create the war file again with the changes you made
5)so,stop the server(ctrl-c and press y)
6)open a new cmd.>go to source directory i.e., e: .cd eclipsework servlets>do an ant clean deploy
7)Start the server again
8)open a browser and type the following URL
9)http://localhost:8080/ServletCRUDAppWithHibernate (that is your projects context path)