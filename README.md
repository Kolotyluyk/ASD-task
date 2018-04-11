# ASD-task

Used tecnology:
- Ant + ivy
- myBatis
- MYSQL
- SMTP(javax.mail)
- POI
the program accepts the query with the parameters:
- Mail to which the data will be sent
- filter
- form document (docx xslx)
After receiving the request, the parameters are transferred to the level of services where the information is extracted from db, 
a file of the required format is established and sent to the mail
