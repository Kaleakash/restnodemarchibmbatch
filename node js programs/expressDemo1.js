var express = require("express");
var app = express();
var path = require("path");
var bodyParser = require("body-parser");
var mysql = require("mysql");
//it  use to enable the body part data
app.use(bodyParser.urlencoded({extended:false}));
var con = mysql.createConnection({
    host:"localhost",
    user:"root",
    password:"root",
    database:"mydb"
});
con.connect(function(err){
    if(err){
        console.log("Error generated"+err);
    }else {
        console.log("Database connected successfully...")
    }
});

var qry = "select * from employee"
app.get("/empDb",function(req,res){

    con.query(qry,function(error,result){
            if(!error){
                res.json(result);
            }
    });

});

app.post("/storeEmpDb",function(req,res){
    //4 = req.body.id, Balaji = req.body.name, 22000 = req.body.salary
    con.query("insert into employee values(?,?,?)",
    [4,"Balaji",22000],function(err){
        if(err){
            res.send("REcord not insert"+err.message);
        }else {
            res.send("Record insert")
        }
    })
});


app.get("/",function(req,res){
    //res.send("Welcome to Node JS Express Module")
   res.sendFile(path.join(__dirname+"/login.html"))
});
app.post("/checkUserDetails",function(req,res){
        var user = req.body.user;
        var pass = req.body.pass;
        if(user=="Ajay" && pass=="123"){
            res.send("Successfully Login - User")
        }else {
             res.send("Failure try once again!")   
        }
});
app.get("/checkUser",function(req,res){
    var user = req.query["user"];
    var pass = req.query["pass"];
    if(user=="Ram" && pass=="123"){
       res.send("Successfully Login")
    }else {
        res.send("Failure try once again")
    }
});
var empInfo = {"id":100,"name":"RAvi","salary":12000};
app.get("/empInfo",function(req,res){
    res.json(empInfo);
})
var employeeDetails = 
[{"id":100,"name":"RAvi","salary":12000},
{"id":101,"name":"Ramesh","salary":14000},
{"id":102,"name":"Rajesh","salary":16000},
{"id":103,"name":"Ramu","salary":18000}                       
]

app.get("/employeesInfo",function(req,res){
    res.json(employeeDetails);
})
app.listen(9999,function(){
    console.log("Server is running on port number 9999")
})