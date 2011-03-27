/*
 * CommonJS module for Gus implementations of HTTP functionality
 */

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

/*
 * public: Request prototype
 */
var Request = exports.Request = function (message) {
  var self = this;
  var messageParts = message.split("\r\n\r\n"),
    metadata = messageParts[0].split("\r\n"),
    body = messageParts[1];

  var merge = function (object) {
    for (var p in object) { self[p] = object[p]; }
  }

  merge(parseRequestLine(metadata.shift()));
  self["headers"] = parseHeaders(metadata);
  self["body"] = body;
}; // Request

