// TRY RUNNING IT FROM THE COMMAND LINE!
// > node echo.cgi
// CTRL+D to exit after entering input

var util = require('util');

console.log("Status: 200");
console.log("Content-Type: text/plain\n\n");

// Dump the ENV variables
console.log(util.inspect(process.env) + "\n");

// Read the message body

var body = "";

process.stdin.on("data", function (chunk) {
  body += chunk;
});

process.stdin.on("end", function () {
  console.log("MESSAGE BODY\n\n" + body);
});

process.stdin.resume();

