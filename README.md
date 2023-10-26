#images {
    white-space: nowrap;
}

<h1>reservationproject</h1>
<div id="images">
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
    <img src="https://img.shields.io/badge/Microsoft%20SQL%20Server-CC2927?style=for-the-badge&logo=microsoft%20sql%20server&logoColor=white" />
    <img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white" />
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" />
</div>

<p>This project was my trial trip in spring boot world. I decided to make THIS app, because I work in Irish Pub as manager and we had a lot of problem with reservation system. Now everyone can use that version and configure it by themself.</p>

<p>It does not have pretty view - I didn't use css styles, but the main feature - reservation system, work fine.</p>

<p>To run my "table reservation" project do next steps:</p>
<ol>
<li>Download zip from github to preferable destionation
<li>Open folder in preferable IDE and check, have you installed maven and spring boot
<li>Install MSSQL
<li>Run queries from (query folder) to deploy database and create function TIMETABLE
<li>Create new user "BESTUSER" and give grants to SELECT and INSERT into tables(Reservation and Request)
<li>Change name and password in APPCONFIG.CLASS
<li>Run application as spring boot app
<li>Open page "localhost:8080" in browser
<li>Make reservations!
</ol>
