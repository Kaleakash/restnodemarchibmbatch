var fs = require("fs");
var msg = "Welcome to Node JS Fs Module";
fs.writeFile("demo1.txt",msg,function(err){
    if(!err){
        console.log("Data Stored in file");
    }
})

