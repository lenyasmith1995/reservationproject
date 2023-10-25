# reservationproject

This project was my trial trip in spring boot world. I decided to make THIS app, because I work in Irish Pub as manager and we had a lot of problem with reservation system. Now everyone can use that version and configure it by themself.

It does not have pretty view - I didn't use css styles, but the main feature - reservation system, work fine.

To run my "table reservation" project do next steps:
1.Download zip from github to preferable destionation
2.Open folder in preferable IDE and check, have you installed maven and spring boot
3.Install MSSQL
4.Run queries from (query folder) to deploy database and create function TIMETABLE
5.Create new user "BESTUSER" and give grants to SELECT and INSERT into tables(Reservation and Request)
6.Change name and password in APPCONFIG.CLASS
7.Run application as spring boot app
8.Open page "localhost:8080" in browser
9.Make reservations!
