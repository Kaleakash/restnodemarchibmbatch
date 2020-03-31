var http = require("http");
var server = http.createServer(function(req,res){
        console.log(req.url);
        console.log(req.method);
        console.log(req.headers);
        console.log(req.httpVersion);
        res.write("Welcome")
        res.write("Welcome again")
        res.write("Welcome once again...")
        res.end();
});
server.listen(9999);
console.log("Server is running on port number 9999")