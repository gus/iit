var http = require('http'),
    util = require('util');

/*
 * Stuff like this should be your criterion for choosing a language
 * and framework.
 */
http.createServer(function (request, response) {
  console.log(util.inspect(request));
  response.writeHead(200, {'Content-Type': 'text/plain'});
  response.end('Thanks!\n');
}).listen(8080, "127.0.0.1");

console.log("Fancy schmancy web server running at http://127.0.0.1:8080/");

