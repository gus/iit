var net = require('net'),
    util = require('util');

var parseRequestLine = function (line) {
  var parts = line.split(/ +/);
  return {
    "method": parts[0],
    "uri": parts[1],
    "version": parts[2]
  };
}; // parseRequestLine

var parseHeaders = function (headerLines) {
  var headers = {};
  for (var i=0, n = headerLines.length; i<n; i++) {
    var line = headerLines[i],
        colon = line.indexOf(":");
    headers[line.slice(0, colon)] = line.slice(colon + 2);
  }
  return headers;
}; // parseHeaders

var buildRequest = function (requestMessage) {
  var messageParts = requestMessage.split("\r\n\r\n"),
      metadata = messageParts[0].split("\r\n"),
      body = messageParts[1];

  var request = parseRequestLine(metadata.shift());
  request["headers"] = parseHeaders(metadata);
  request["body"] = body;
  return request;
}; // buildRequest

// Creating a TCP server
var server = net.createServer(function (socket) {
  console.log("Connection from " + socket.remoteAddress);

  socket.on("data", function (data) {
    // BUT: what if the incoming message is chunked?
    var request = buildRequest(data.toString());
    console.log(util.inspect(request));

    socket.write("HTTP/1.1 200 OK\r\nContent-Length: 8\r\n\r\nThanks!\n");
  });

  socket.on("close", function (data) {
    console.log("Client closed connection");
  });

}); // net.createServer

server.listen(8081, "127.0.0.1");

console.log("HTTP Server listening on 127.0.0.1 port 8081");
