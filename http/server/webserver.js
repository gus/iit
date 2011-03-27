var http = require('http');

/*
 * Stuff like this should be your criterion for choosing a language
 * and framework.
 */
http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.end('Thanks!\n');
}).listen(8080, "127.0.0.1");

console.log("Fancy schmancy web server running at http://127.0.0.1:8080/");

