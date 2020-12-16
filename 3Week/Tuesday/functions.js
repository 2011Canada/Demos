




let x = function(){
    console.log("I am a function");
}

x();

//this is a function that takes in a sperate function as a param
function callFunctionWithHelloWorld (funcToCall){
    //it then calls its param with a specific string
    funcToCall("Hello World")
}

//this is a function that takes in a string
let print = function (stringToPrint){
    //then it prints that string to the console
    console.log(stringToPrint)
}

//we pass our printing function into our calling function
callFunctionWithHelloWorld(print)
//the calling function calls the printing function with the string Hello World




function thatDisplaysSomethingPretty(){

}

function putsABorderAroundADisplay(display){
    makeAfancyBorder = true;
    fancyBorder()
    display()
}


function sendRequestToADatabase(whatToDoWithReturnedData){
    let data = sendsRequest()
    whatToDoWithReturnedData(data)
}
//higher order functions
//take in a function as a param and enhance it in someway


//anywhere you can put a function you can also put a lambda function


callFunctionWithHelloWorld((st)=>{
    st += st
    console.log(`My String is ${st}`)
})


function named(){
    this//refers to the object that is named
}

//lambda syntax

let named2 = () => {
    this//refers to the object that is the global scope, because arrow functions have no this
}

let arrow2 = ele => ele + "some string"


function hoc(params, functionToCall){
    //modify params in some way
    functionToCall(params)
}

let obj = { 

};

let scopes = ()=>{
    let scopes2 = ()=>{

    }
    scopes2()
}

scopes2//no longer exists