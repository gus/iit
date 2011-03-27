var net = require('net');

// Creating a TCP server
var server = net.createServer(function (socket) {
  console.log("Connection from " + socket.remoteAddress);
  socket.write("Connected to echo server\r\n");

  socket.pipe(socket); // duplexed stream; writes what it reads

  socket.on("data", function (data) {
    console.log("Data received");
  });

  socket.on("close", function () {
    console.log("Connection closed");
  });
})

server.listen(8082, "127.0.0.1");

console.log("Echo Server listening on 127.0.0.1 port 8082");
