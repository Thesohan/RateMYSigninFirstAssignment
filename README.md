# RateMYSigninFirstAssignment
This project is a part of an assingment

### Tasks:

1. Create an Android UI screen (Activity) which displays a list (Recycled View) of 10 users with details (Horizontal Layout) as name and age. You can hardcode the user values in this task.
2. Attach a listener to the firebase realtime database (JSON Tree), the database has a list of 10 users. Listners keeps UI synced with database values, any change in database value is updated at UI in realtime. Please setup your own firebase account and create realtime database. You can manually insert the user details in database from Firebase Admin Console.
In database structure (JSON Tree)<br/>
-> ROOT<br/>
--> 	USER (Contains list of unique ids)<br/>
--->		UniqueID<br/>
---->			Name<br/>
---->			Age<br/>
3. Write Firebase cloud function which triggers on create of a new user in realtime database (tast#2). It ensures that only latest 10 records are present in database, any old user records are removed. Good if you could deploy it and run on firebase server.

