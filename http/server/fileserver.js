var http = require('http'),
    util = require('util'),
    fs   = require('fs'),
    URL  = require('url');

var config = {
  "root": "./htdocs",
  "default_file": "/index.html",
  "404": "./htdocs/404.html"
};

var mapToFile = function(path) {
  var filename = config.root + path;
  try {
    var stat = fs.statSync(filename);

    if (stat.isDirectory()) {
      // NOTE: This is by no means a necessary action
      filename = (filename + config.default_file).replace(/\/\//g, "/");
    } else if (! stat.isFile()) {
      // Well, it's something ... but what is it?
      filename = null;
    }
  } catch (e) {
    console.log("Resource not found [" + path + "]");
    filename = null;
  }
  return filename;
};

// This is a very basic status mapper
var mapToStatus = function(filename) {
  return (filename == undefined) ? [404, config["404"]] : [200, filename];
}

//
// Where the magic begins
http.createServer(function (request, response) {
  var url = URL.parse(request.url),
      statusAndFile = mapToStatus(mapToFile(url.pathname)),
      statusCode = statusAndFile[0],
      filename = statusAndFile[1];

  response.writeHead(statusCode, {"Content-Type": "text/html"});
  response.end(fs.readFileSync(filename));

  console.log("Requested [" + request.url + "]");
  console.log("Delivered [" + filename + "]");
}).listen(8080, "127.0.0.1");

console.log("Fancy file server running at http://127.0.0.1:8080/");

