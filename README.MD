# Rest api for pomodoro frontend projects
**The dependency manager used was maven**

---

# Api Endpoint

---

### **Create user**
### **(POST) api/user**

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
### **(POST) api/login**

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
### **(PUT) api/user/password**

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
### **(DELETE) api/user/{userId}**
**(REQUEST BODY)**
```json
{
  "password": "2342364564564564"
}
```

---

### **Add session**
### **(POST) api/{userId}/session**
**(REQUEST BODY)**

```json
{
	"title": "inglês",
	"timeSession": "04:23:00"
}
```
---

### **Show user sessions**
### **(GET) api/{userId}/all-sessions**
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

