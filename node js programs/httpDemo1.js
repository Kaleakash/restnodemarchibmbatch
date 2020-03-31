var http = require("http");
var port = 9999;
var server = http.createServer(function(req,res){
        if(req.url=="/aboutus"){
            res.write("Welcome to About Us Page")
        }
        else if(req.url=="/contactus"){
            res.write("Welcome to Contact us")
        }else if(req.url=="/login"){
            res.write("Welcome to Login Page")
        }else {
            res.write("Page NOt found")
        }
        res.end();
});
server.listen(port);
console.log(`server running on port number ${port}`)

