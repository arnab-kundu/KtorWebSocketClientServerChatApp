# MongoDB


## Introduction
MongoDB is a noSQL Database. It is a document DB. All the records are saved as a documnet in Json format.

| SQL Name | Equivalent name in MongoDB |
|----------|----------------------------|
| Database | db                         |
| Table    | collection                 |
| Row      | document                   |


## Donwload MongoDB
Download MongoDB community version from the official website of MondoDB.

- Here is the [link](https://www.mongodb.com/try/download/community) of MongoDB website.
 - Or click [here](https://fastdl.mongodb.org/windows/mongodb-windows-x86_64-6.0.8-signed.msi) to download the latest version. Size of the file is 482 MB.


## Installing MongoDB
To install double click on the setup file called `mongodb-windows-x86_64-6.0.8-signed.msi`
Click Next -> Accept -> Complete -> Uncheck the MongoDB Compass checkbox.

 - Open CMD
 - Run `C:/> mkdir data\db` to create this folders


## Start MongoDB Server
This below steps need to be followed every time when you want to start MongoDB server.
 - Open cmd
 - `cd C:\Program Files\MongoDB\Server\4.2\bin`
 - To start mongoDB server: `C:\Program Files\MongoDB\Server\4.2\bin> mongod`
 - Server will be started on port: **27017**
 - Keep the server running in that cmd window
 - Open a new cmd window
 - Again `cd C:\Program Files\MongoDB\Server\4.2\bin`
 - To start mongoDB in console: `C:\Program Files\MongoDB\Server\4.2\bin> mongo`


 ## Importent tips
 Copy/Paste tips in MongoDB shell
  - Select the text and hit enter to **Copy**
  - And Right click to **Paste**


## MongoDB GUI Tool
 - Install MongoChef
 - now Studio 3T
 - nosqlbooster4mongo-6.1.8 (Used)


# MongoDB query

 - ## Create Database and Drop Database
```
show dbs
use <database name>
db.version()
db.dropDatabase()


show collections
db.<collection name>.find()
db.<collection name>.find().pretty()
```
 - ## Create Collection and Drop Collection
```
db.createCollection('<collection name>')
db.createCollection('<collection name>',Option)
db.<collcetion name>.drop()
```

 - ## Insert Documents
```
db.<collection name>.insert(<JSON Obejct/ JSON Array>)
db.<collection name>.insert( { "name" : "Arnab" } )
db.emplyoee.insert({"name":"Arnab", "gender":"M"})
db.emp.save({"name":"Arnab","lastname":"kundu","Rank":1})
db.emp.save([
	{ "name" : "Arnab", "lastname" : "Kundu", "Rank" : 1 },
	{ "name" : "Alex", "lastname" : "Kundu", "Rank" : 2 },
	{ "name" : "Anna", "lastname" : "Kundu", "Rank" : 3 },
	{ "name" : "Kevin", "lastname" : "Kundu", "Rank" : 4 }
])
```
 - ## Query Document
```
db.emp.find()
db.emp.find().pretty()
db.emp.findOne()
db.emp.find({"Rank":0})
db.emp.find({"Rank":1})
db.emp.find({"Rank":{$gt : 2}})
db.emp.find({"Rank":{$gte : 2}})
db.emp.find({"Rank":{$lt : 2}})
db.emp.find({"Rank":{$lte : 2}})
db.emp.find({"Rank":{$ne : 2}})
db.emp.find({"Rank":{$ne : 2}}).pretty()
db.users.find({"name": /.*m.*/})
db.users.find({"name": /m/})
db.users.find({"name": /^m/})
```
 - ## Query Document - AND OR Conditions
```
db.emp.find({"name":"Arnab","Rank":1})
db.emp.find({$or:[{"name":"Arnab"},{"Rank":2}]})
db.emp.find({$or:[{"name":"Arnab"},{"name":"Alex"}]})
db.emp.find({$or:[{"name":"Arnab"},{"lastname":"Kundu"}]})
db.emp.find({$or:[{"name":"Arnab"},{"name":/ab/}]})
db.emp.find( { "name":"Arnab" , $or:[ {"Rank": 1}, {"Rank":2 } ]})
db.emp.find( { "name":"Alex" , $or:[ {"Rank": 1}, {"Rank":2 } ]})
db.emp.find( { "name":"Anna" , $or:[ {"Rank": 1}, {"Rank":3 } ]})
```
 - ## MongoDB Update Document
```
db.emp.update({"_id" : ObjectId("5f8fd51c5ce387746c43ba63")},{$set: {"name":"Alex","lastname":"Kumar"}})

db.emp.update({"lastname":"kundu"},{$set: {"lastname":"Kundu"}},{multi:true})

db.emp.save({ "_id" : ObjectId("5f8fd51c5ce387746c43ba63"), "name" : "Alex", "lastname" : "Kundu", "Rank" : 2 })
```
 - ## MongoDB Delete Document
```
db.emp.remove({"Rank":4})
db.emp.remove({"lastname":"Kundu"})
db.emp.remove({"lastname":"Kundu"},1)
```

 - ## MongoDB Projection
========================
```
db.emp.find({},{"name":1})
db.emp.find({},{"name":1,"_id":0})
```

 - ## Using Sort, Skip, and Limit in MongoDB
============================================
```
db.emp.find().limit(2)
db.emp.find().skip(1)
db.emp.find().skip(1).limit(2)
db.emp.find().sort({"Rank":1})
db.emp.find().sort({"Rank":-1})
db.emp.find().sort({"name":1})
```

 - ## MongoDB Indexing
```
use temp
for(i=0;i<10000000; ++i){
    db.posts.insert({"student_id": i, "name" : "Mark"});
}
goto cmd
db.posts.find()
db.posts.find({"student_id" : 1000});
db.posts.findOne({"student_id" : 1000});

db.posts.ensureIndex({"student_id" : 1});
db.posts.find({"student_id" : 100000});

db.posts.dropIndex({"student_id" : 1});
db.posts.find({"student_id" : 100000});
```

 - ## MongoDB Aggregation
```
db.emp.aggregate([{ $group : {_id : "$lastname", Count : {$sum:1} } }])
```

## MongoDB BackUp and Restore
```
->open cmd as admin then move to 
->cd C:\Program Files\MongoDB\Server\4.2\bin
mongodump -> will create dump folder in the same location
mongorestore -> will restore all dump database from dump folder
mongodump --db mydb
use mydb
db.dropDatabase()
show dbs
mongorestore --db mydb dump/mydb
show dbs
```
## Backup and Restore Collection
```
mongodump --db <database name> --collection <collection name>
use <database name>
db.<collection name>.drop()
mongorestore -db <database name> --collcetion <collection name> dump/<database name>/collection name>.bson
```
 - Note: Backup restore working in monogodb version 4.2 or lower
To chack db version use-> db.version()

