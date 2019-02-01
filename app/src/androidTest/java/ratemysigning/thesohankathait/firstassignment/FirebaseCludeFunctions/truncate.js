// imSports firebase-functions module
const functions = require('firebase-functions');
// imports firebase-admin module
const admin = require('firebase-admin');


// Initialize your firebase-admin app instance. It helps to trigger firebase events

admin.initializeApp(functions.config().firebase);


// Max number of user.
const MAX_LOG_COUNT = 10;

// Removes siblings of the node that element that triggered the function if there are more than MAX_LOG_COUNT.
// In this example we'll keep the max no. of user  to MAX_LOG_COUNT.
exports.truncate = functions.database.ref('/User/{Uid}').onWrite((change) => {
  const parentRef = change.after.ref.parent;//When handling a Realtime Database event,
  // the data object returned is a DataSnapshot.
  // For onWrite or onUpdate events, the first parameter is a Change object that contains
  // two snapshots that represent the data state before and after the triggering event.
  // For onCreate and onDelete events, the data object returned is a snapshot of the data created or deleted.
  console.log("current parentRef = "+parentRef)
  return parentRef.once('value').then((snapshot) => {
    if (snapshot.numChildren() >= MAX_LOG_COUNT) {
      let childCount = 0;
      const updates = {};
      snapshot.forEach((child) => {
        if (++childCount <= snapshot.numChildren() - MAX_LOG_COUNT) {
          updates[child.key] = null;
        }
      });
      // Update the parent. This effectively removes the extra children.
      return parentRef.update(updates);
    }
    return null;
  });
});
