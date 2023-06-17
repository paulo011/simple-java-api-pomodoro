# Rest api for pomodoro frontend projects
**Requirements**
* Java 17
* Maven
* Spring Web
* Spring JPA
* Spring Validation
* H2
* Postgresql (Optional)
* Lombok

---

# **Api Endpoint**


## **Create user**
(POST) api/user

**(REQUEST BODY)**
````json
{
  "firstName": "Joel",
  "lastName": "Ciclone",
  "nickName": "JoelCiclone",
  "email": "joelciclone@email.com",
  "password": "2342364564564564",
  "birthDate": "1990/12/12",
  "gender": "0"
}
````

**(RESPONSE BODY)**
````json
{
  "id": 1,
  "firstName": "Joel",
  "lastName": "Ciclone",
  "nickName": "JoelCiclone",
  "email": "joelciclone@email.com",
  "gender": "Male",
  "birthDate": "1990/12/12"
}
````
---

### **User login**
(POST) api/login

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
  "id": 1,
  "firstName": "Joel",
  "lastName": "Ciclone",
  "nickName": "JoelCiclone",
  "email": "joelciclone@email.com",
  "gender": "Male",
  "birthDate": "1990/12/12"
}
```
---

### **Password Change**
(PUT) api/user/{userId}/password

**(REQUEST BODY)**
````json
{
  "oldPassword": "2342364564564564",
  "newPassword": "newPassword"
}
````

**(RESPONSE BODY)**
```text
successfully changed password
```

---
### **Delete user**
(DELETE) api/user/{userId}

**(REQUEST BODY)**
```json
{
  "password": "2342364564564564"
}
```

**(RESPONSE BODY)**
```text
User deleted
```

---

### **Add session**
(POST) api/{userId}/session

**(REQUEST BODY)**
```json
{
  "title": "Italian",
  "timeSession": "23:10:00"
}
```

**(RESPONSE BODY)**
```json
{
    "title": "Italian",
    "timeSession": {
        "hours": 23,
        "minutes": 10,
        "seconds": 0
    }
}
```
---

### **Show user sessions**
(GET) api/{userId}/all-sessions

**(RESPONSE BODY)**
```json
{
  "totalSessionsTime": {
    "hours": 71,
    "minutes": 55,
    "seconds": 0
  },
  "listSessions": [
    {
      "title": "inglês",
      "timeSession": {
        "hours": 4,
        "minutes": 23,
        "seconds": 0
      }
    },
    {
      "title": "Hindi",
      "timeSession": {
        "hours": 44,
        "minutes": 22,
        "seconds": 0
      }
    },
    {
      "title": "Italian",
      "timeSession": {
        "hours": 23,
        "minutes": 10,
        "seconds": 0
      }
    }
  ]
}
```
---

