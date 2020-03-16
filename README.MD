Online English school "Eugenia"

API
By default, application port is 8080

Endpoints

---------------------------------------------------------------------------------------------------
Teacher 
POST /

to add a teacher : 
Expected request example:

{
	"id" : 1,
	"name" :"Vasia",
	"lastname": "Pupkin",
	"email" :"vasiaPupkin@gmail.com"
}			




to remove a teacher that exists :
    endpoint :
        http://localhost:8080/teachers/delete
    Expected request example:
{
	"teacher":{
		"id" : 1	
	}
}


end of teacher
--------------------------------------------------------------------------------------------

Student


to add a student :
    endpoint :
    
    POST
/students/add
Expected request example:
{
	"id" : 1,
	"name": "John Dow",
	"Role" : "activeStudent"
	}




end of Student
___________________________________________________________________________________
SCHEDULE

to add a schedule 




end of schedule 
-----------------------------------------

create self-destructing message.

Expected request body example:
Response body example:

Response status should be 201 CREATED

GET /{uuid}


Expected response body example:

{
  "text": "shared secret"
}
DELETE /{uuid}

Remove (drop) self-destructing message. Response body should be empty

