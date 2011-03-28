# HTTP Notes

* Let's just start with TCP and sockets (echoserver.js)
  * Why doesn't `curl` work with echoserver?

* Make `curl` work with httpserver.js
  * curl -v "http://localhost:8080/"
  * curl -v "http://localhost:8080/foo/bar.html"
  * curl -v --data "baz=bee" "http://localhost:8080/"   # check out the http method

* Great, but that's a lot of code (httpserver2.js)
  * curl -v "http://localhost:8080/"
  * curl -v "http://localhost:8080/foo/bar.html"
  * curl -v --data "baz=bee" "http://localhost:8080/"
  
* Well, neat, but "Thanks!" isn't all that useful. When I think of the web, I think of information (fileserver.js)
  * [What is HTTP?](http://localhost:8080/)
    * curl -v "http://localhost:8080/"
  * URIs/URLs
  * Status Codes
  * Maintaining state (cookies)

* What if you want to attach your language to my webserver? (CGI)

* Rails
  * How does rails work (cgi or something else)?

