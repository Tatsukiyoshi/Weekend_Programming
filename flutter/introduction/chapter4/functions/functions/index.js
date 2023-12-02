/**
 * Import function triggers from their respective submodules:
 *
 * const {onCall} = require("firebase-functions/v2/https");
 * const {onDocumentWritten} = require("firebase-functions/v2/firestore");
 *
 * See a full list of supported triggers at https://firebase.google.com/docs/functions
 */

const {onRequest} = require("firebase-functions/v2/https");
const logger = require("firebase-functions/logger");

// Create and deploy your first functions
// https://firebase.google.com/docs/functions/get-started

const functions = require("firebase-functions");

// リスト4.16(HTTP) -> リスト4.19
// 必要なモジュールの読み込みと初期化
const admin = require("firebase-admin");
admin.initializeApp();

exports.helloWorld = onRequest((request, response) => {
    logger.info("Hello logs!", {structuredData: true});
    var docRef = admin.firestore().doc("testCollection1/testDocument1");
    docRef.get().then(doc => {
        if(doc.exists){
            response.send(doc.data())
        } else {
            response.send("nodata")
        }
        return null;
    }).catch(error => {
        response.send("error")
    })
});

// リスト4.17(Timer)
exports.timer1 = functions.pubsub.schedule('every 5 minutes').onRun
((context) => {
    functions.logger.info("timer1 start", {structuredData: true});
    return null;
});

exports.timer2 = functions.pubsub.schedule('*/3 * * * *').onRun
((context) => {
    functions.logger.info("timer2 start", {structuredData: true});
    return null;
});

// リスト4.18(Cloud Firestore)
exports.db1 = functions.firestore.document('testCollection1/testDocument1').onWrite((change, context) => {
    functions.logger.info("DBChange", {structuredData: true});
    return null;
});
