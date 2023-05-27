# Rest api for pomodoro frontend projects
**The dependency manager used was maven**

---

# Api Endpoint
**(BASEURL) /api**

---

### **Create user**
### **(POST) /user**

**(REQUEST BODY)**
````json
{
  "firstName": "Joel",
  "lastName": "Ciclone",
  "nickName": "JoelCiclone",
  "email": "joelciclone@email.com",
  "password": "2342364564564564",
  "birthDate": "1996/05/10",
  "gender": "0"
}
````

**(RESPONSE BODY)**
````json
{
  "id": "1",
  "firstName": "Joel",
  "lastName": "Ciclone",
  "nickName": "JoelCiclone",
  "email": "joelciclone@email.com",
  "password": "2342364564564564",
  "birthDate": "1996/05/10",
  "gender": "male"
}
````
---

### **User login**
### **(POST) /login**

**(REQUEST BODY)**
```json
{
  "nickName": "JoelCiclone",
  "password": "2342364564564564"
}
```
**(RESPONSE BODY)**
```json
{
  "id": "1",
  "firstName": "Joel",
  "lastname": "Ciclone",
  "nickName": "JoelCiclone",
  "email": "joelciclone@email.com",
  "birthDate": "1996/05/10",
  "gender": "male"
}
```
---

### **Password Change**
### **(PUT) user/{UserId}/password**

**(REQUEST BODY)**
````json
{
  "email": "joelciclone@email.com",
  "oldPassword": "2342364564564564",
  "newPassword": "45345344"
}
````
---
### **Delete user**
### **(DELETE) /user/{userId}**
**(REQUEST BODY)**
```json
{
  "password": "2342364564564564"
}
```

---

### **Add session**
### **(POST) user/{userId}/session**
**(REQUEST BODY)**

```json
{
	"title": "inglês",
	"timeSession": "04:23:00"
}
```
---

### **Show user sessions**
### **(GET) user/{userId}/all-sessions**
**(RESPONSE BODY)**
```json
{
  "totalTimeAllTasks": "80:04:00",
  "listSessions": [
    {
      "title": "inglês",
      "totalTime": "12:42:00"
    },
    {
      "title": "Hindi",
      "totalTime": "44:22:00"
    },
    {
      "title": "Italian",
      "totalTime": "23:10:00"
    }
  ]
}
```
---

