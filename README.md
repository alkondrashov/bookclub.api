---------------------------------
Example usage
---------------------------------
```
curl testjwtclientid:XY7kmzoNzl100@fh-transaction.herokuapp.com/oauth/token -d grant_type=password -d username=admin -d password=jwtpass
```

> Bearer token response:
```javascript
{
   "access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTUyOTUwMTg5LCJhdXRob3JpdGllcyI6WyJBRE1JTl9VU0VSIl0sImp0aSI6IjljOWZjOWY4LTRjNzItNDdmYi1iOTYwLWIxZDcwNWQ4OTMxNyIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.Pcn4D6kmhtcbxypWNtQCAMsGYOGsvijRCxKVydQ8Jk0",
   "token_type":"bearer",
   "expires_in":43199,
   "scope":"read write",
   "jti":"9c9fc9f8-4c72-47fb-b960-b1d705d89317"
}
```

> Get all transactions:

``` 
curl  http://fh-transaction.herokuapp.com/api/transactions -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTUyOTUwMTg5LCJhdXRob3JpdGllcyI6WyJBRE1JTl9VU0VSIl0sImp0aSI6IjljOWZjOWY4LTRjNzItNDdmYi1iOTYwLWIxZDcwNWQ4OTMxNyIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.Pcn4D6kmhtcbxypWNtQCAMsGYOGsvijRCxKVydQ8Jk0"
```

> Get all clients:

``` 
curl  http://fh-transaction.herokuapp.com/api/client -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTUyOTUwMTg5LCJhdXRob3JpdGllcyI6WyJBRE1JTl9VU0VSIl0sImp0aSI6IjljOWZjOWY4LTRjNzItNDdmYi1iOTYwLWIxZDcwNWQ4OTMxNyIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.Pcn4D6kmhtcbxypWNtQCAMsGYOGsvijRCxKVydQ8Jk0"
```
 
> Get client with id 1:

```
curl  http://fh-transaction.herokuapp.com/api/client/1 -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTUyOTUwMTg5LCJhdXRob3JpdGllcyI6WyJBRE1JTl9VU0VSIl0sImp0aSI6IjljOWZjOWY4LTRjNzItNDdmYi1iOTYwLWIxZDcwNWQ4OTMxNyIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.Pcn4D6kmhtcbxypWNtQCAMsGYOGsvijRCxKVydQ8Jk0"
```

> Example client api response:
```javascript 
[
   {
      "customerInfo":{
         "id":1,
         "created_at":"2015-10-09 12:09:10",
         "updated_at":"2015-10-09 12:09:10",
         "number":"401288XXXXXX1881",
         "expiryMonth":"6",
         "expiryYear":"2017",
         "email":"aydinATgmail",
         "birthday":"1986-03-20 12:09:10",
         "Authorization":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJ ZCI6MSwicm9sZSI6ImFkbWluIiwibWVyY2hhbnRJZCI6MSwic3ViTWVyY hhbnRJZHMiOltdLCJ0aW1lc3RhbXAiOjE0NDQzODk4ODB9.zPxVu4fk y1uG2fO3X2RbxiI4otK_HG7M4MMTB298"
      },
      "billingFirstName":"Aydin",
      "billingLastName":"Gungordu",
      "billingAddress1":"test address",
      "billingCity":"Antalya",
      "billingPostcode":"7070",
      "billingCountry":"TR",
      "shippingFirstName":"Aydin",
      "shippingLastName":"Gungordu",
      "shippingAddress1":"test address",
      "shippingCity":"Antalya",
      "shippingPostcode":"7070",
      "shippingCountry":"TR"
   }
]
```

---------------------------------
Build locally
---------------------------------
`mvn clean install`

Docker build: 
`mvn clean package docker:build`
