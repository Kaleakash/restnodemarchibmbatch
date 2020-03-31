var fs = require("fs");
/*fs.readFile("demo.txt",function(err,data){
     if(!err){
        console.log(data.toString());
    }else {
        console.log("File is not preset"+err)
    }
})*/
var data = fs.readFileSync("demo.txt");
console.log(data.toString());
console.log("normal 1st message");
console.log("normal 2nd message");
console.log("normal 3rd message");
console.log("normal 4th message");
console.log("normal 5th message");
