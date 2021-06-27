# Swagger Petstore


<a name="overview"></a>
## Overview
This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.


### Version information
*Version* : 1.0.2


### Contact information
*Contact Email* : apiteam@swagger.io


### License information
*License* : Apache 2.0  
*License URL* : http://www.apache.org/licenses/LICENSE-2.0.html  
*Terms of service* : http://swagger.io/terms/


### URI scheme
*Host* : petstore.swagger.io  
*BasePath* : /v2  
*Schemes* : HTTPS, HTTP


### Tags

* pet : Everything about your Pets
* store : Access to Petstore orders
* user : Operations about user


### External Docs
*Description* : Find out more about Swagger  
*URL* : http://swagger.io




<a name="paths"></a>
## Paths

<a name="addpet"></a>
### Add a new pet to the store
```
POST /pet
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Pet object that needs to be added to the store|[Pet](#pet)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**405**|Invalid input|No Content|


#### Consumes

* `application/json`
* `application/xml`


#### Produces

* `application/xml`
* `application/json`


#### Tags

* pet


#### Security

|Type|Name|Scopes|
|---|---|---|
|**oauth2**|**[petstore_auth](#petstore_auth)**|write:pets,read:pets|


<a name="updatepet"></a>
### Update an existing pet
```
PUT /pet
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Pet object that needs to be added to the store|[Pet](#pet)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Invalid ID supplied|No Content|
|**404**|Pet not found|No Content|
|**405**|Validation exception|No Content|


#### Consumes

* `application/json`
* `application/xml`


#### Produces

* `application/xml`
* `application/json`


#### Tags

* pet


#### Security

|Type|Name|Scopes|
|---|---|---|
|**oauth2**|**[petstore_auth](#petstore_auth)**|write:pets,read:pets|


<a name="findpetsbystatus"></a>
### Finds Pets by status
```
GET /pet/findByStatus
```


#### Description
Multiple status values can be provided with comma separated strings


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**status**  <br>*required*|Status values that need to be considered for filter|< enum (available, pending, sold) > array(multi)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|successful operation|< [Pet](#pet) > array|
|**400**|Invalid status value|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* pet


#### Security

|Type|Name|Scopes|
|---|---|---|
|**oauth2**|**[petstore_auth](#petstore_auth)**|write:pets,read:pets|


<a name="findpetsbytags"></a>
### Finds Pets by tags
```
GET /pet/findByTags
```

Caution : 
operation.deprecated


#### Description
Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**tags**  <br>*required*|Tags to filter by|< string > array(multi)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|successful operation|< [Pet](#pet) > array|
|**400**|Invalid tag value|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* pet


#### Security

|Type|Name|Scopes|
|---|---|---|
|**oauth2**|**[petstore_auth](#petstore_auth)**|write:pets,read:pets|


<a name="updatepetwithform"></a>
### Updates a pet in the store with form data
```
POST /pet/{petId}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**petId**  <br>*required*|ID of pet that needs to be updated|integer (int64)|
|**FormData**|**name**  <br>*optional*|Updated name of the pet|string|
|**FormData**|**status**  <br>*optional*|Updated status of the pet|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**405**|Invalid input|No Content|


#### Consumes

* `application/x-www-form-urlencoded`


#### Produces

* `application/xml`
* `application/json`


#### Tags

* pet


#### Security

|Type|Name|Scopes|
|---|---|---|
|**oauth2**|**[petstore_auth](#petstore_auth)**|write:pets,read:pets|


<a name="getpetbyid"></a>
### Find pet by ID
```
GET /pet/{petId}
```


#### Description
Returns a single pet


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**petId**  <br>*required*|ID of pet to return|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|successful operation|[Pet](#pet)|
|**400**|Invalid ID supplied|No Content|
|**404**|Pet not found|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* pet


#### Security

|Type|Name|
|---|---|
|**apiKey**|**[api_key](#api_key)**|


<a name="deletepet"></a>
### Deletes a pet
```
DELETE /pet/{petId}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Header**|**api_key**  <br>*optional*||string|
|**Path**|**petId**  <br>*required*|Pet id to delete|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Invalid ID supplied|No Content|
|**404**|Pet not found|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* pet


#### Security

|Type|Name|Scopes|
|---|---|---|
|**oauth2**|**[petstore_auth](#petstore_auth)**|write:pets,read:pets|


<a name="uploadfile"></a>
### uploads an image
```
POST /pet/{petId}/uploadImage
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**petId**  <br>*required*|ID of pet to update|integer (int64)|
|**FormData**|**additionalMetadata**  <br>*optional*|Additional data to pass to server|string|
|**FormData**|**file**  <br>*optional*|file to upload|file|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|successful operation|[ApiResponse](#apiresponse)|


#### Consumes

* `multipart/form-data`


#### Produces

* `application/json`


#### Tags

* pet


#### Security

|Type|Name|Scopes|
|---|---|---|
|**oauth2**|**[petstore_auth](#petstore_auth)**|write:pets,read:pets|


<a name="getinventory"></a>
### Returns pet inventories by status
```
GET /store/inventory
```


#### Description
Returns a map of status codes to quantities


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|successful operation|< string, integer (int32) > map|


#### Produces

* `application/json`


#### Tags

* store


#### Security

|Type|Name|
|---|---|
|**apiKey**|**[api_key](#api_key)**|


<a name="placeorder"></a>
### Place an order for a pet
```
POST /store/order
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|order placed for purchasing the pet|[Order](#order)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|successful operation|[Order](#order)|
|**400**|Invalid Order|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* store


<a name="getorderbyid"></a>
### Find purchase order by ID
```
GET /store/order/{orderId}
```


#### Description
For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**orderId**  <br>*required*|ID of pet that needs to be fetched|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|successful operation|[Order](#order)|
|**400**|Invalid ID supplied|No Content|
|**404**|Order not found|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* store


<a name="deleteorder"></a>
### Delete purchase order by ID
```
DELETE /store/order/{orderId}
```


#### Description
For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**orderId**  <br>*required*|ID of the order that needs to be deleted|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Invalid ID supplied|No Content|
|**404**|Order not found|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* store


<a name="createuser"></a>
### Create user
```
POST /user
```


#### Description
This can only be done by the logged in user.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Created user object|[User](#user)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**default**|successful operation|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* user


<a name="createuserswitharrayinput"></a>
### Creates list of users with given input array
```
POST /user/createWithArray
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|List of user object|< [User](#user) > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**default**|successful operation|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* user


<a name="createuserswithlistinput"></a>
### Creates list of users with given input array
```
POST /user/createWithList
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|List of user object|< [User](#user) > array|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**default**|successful operation|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* user


<a name="loginuser"></a>
### Logs user into the system
```
GET /user/login
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**password**  <br>*required*|The password for login in clear text|string|
|**Query**|**username**  <br>*required*|The user name for login|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|successful operation  <br>**Headers** :   <br>`X-Rate-Limit` (integer (int32)) : calls per hour allowed by the user.  <br>`X-Expires-After` (string (date-time)) : date in UTC when token expires.|string|
|**400**|Invalid username/password supplied|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* user


<a name="logoutuser"></a>
### Logs out current logged in user session
```
GET /user/logout
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**default**|successful operation|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* user


<a name="getuserbyname"></a>
### Get user by user name
```
GET /user/{username}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**username**  <br>*required*|The name that needs to be fetched. Use user1 for testing.|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|successful operation|[User](#user)|
|**400**|Invalid username supplied|No Content|
|**404**|User not found|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* user


<a name="updateuser"></a>
### Updated user
```
PUT /user/{username}
```


#### Description
This can only be done by the logged in user.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**username**  <br>*required*|name that need to be updated|string|
|**Body**|**body**  <br>*required*|Updated user object|[User](#user)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Invalid user supplied|No Content|
|**404**|User not found|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* user


<a name="deleteuser"></a>
### Delete user
```
DELETE /user/{username}
```


#### Description
This can only be done by the logged in user.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**username**  <br>*required*|The name that needs to be deleted|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**400**|Invalid username supplied|No Content|
|**404**|User not found|No Content|


#### Produces

* `application/xml`
* `application/json`


#### Tags

* user




<a name="definitions"></a>
## Definitions

<a name="apiresponse"></a>
### ApiResponse

|Name|Schema|
|---|---|
|**code**  <br>*optional*|integer (int32)|
|**message**  <br>*optional*|string|
|**type**  <br>*optional*|string|


<a name="category"></a>
### Category

|Name|Schema|
|---|---|
|**id**  <br>*optional*|integer (int64)|
|**name**  <br>*optional*|string|


<a name="order"></a>
### Order

|Name|Description|Schema|
|---|---|---|
|**complete**  <br>*optional*|**Default** : `false`|boolean|
|**id**  <br>*optional*||integer (int64)|
|**petId**  <br>*optional*||integer (int64)|
|**quantity**  <br>*optional*||integer (int32)|
|**shipDate**  <br>*optional*||string (date-time)|
|**status**  <br>*optional*|Order Status|enum (placed, approved, delivered)|


<a name="pet"></a>
### Pet

|Name|Description|Schema|
|---|---|---|
|**category**  <br>*optional*||[Category](#category)|
|**id**  <br>*optional*||integer (int64)|
|**name**  <br>*required*|**Example** : `"doggie"`|string|
|**photoUrls**  <br>*required*||< string > array|
|**status**  <br>*optional*|pet status in the store|enum (available, pending, sold)|
|**tags**  <br>*optional*||< [Tag](#tag) > array|


<a name="tag"></a>
### Tag

|Name|Schema|
|---|---|
|**id**  <br>*optional*|integer (int64)|
|**name**  <br>*optional*|string|


<a name="user"></a>
### User

|Name|Description|Schema|
|---|---|---|
|**email**  <br>*optional*||string|
|**firstName**  <br>*optional*||string|
|**id**  <br>*optional*||integer (int64)|
|**lastName**  <br>*optional*||string|
|**password**  <br>*optional*||string|
|**phone**  <br>*optional*||string|
|**userStatus**  <br>*optional*|User Status|integer (int32)|
|**username**  <br>*optional*||string|




<a name="securityscheme"></a>
## Security

<a name="petstore_auth"></a>
### petstore_auth
*Type* : oauth2  
*Flow* : implicit  
*Token URL* : https://petstore.swagger.io/oauth/authorize


|Name|Description|
|---|---|
|write:pets|modify pets in your account|
|read:pets|read your pets|


<a name="api_key"></a>
### api_key
*Type* : apiKey  
*Name* : api_key  
*In* : HEADER



