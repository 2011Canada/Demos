//lets talk about the 3 scopes in js



//js is not quite like java
//when we start up node, or the browser we generating a new program that represents the entire js environment
//unlike many languages, js supports declaring functions and variables in no speciified scope ( not in a class)
//anything that gets declared at the top level is added to the global scope

let x = 'global';//this is the global scope and anything in the program can access it
//only one of each ID in the global scope
var a = 'global'; //var and let are exactly the same in the global scope


//as soon as function get involved, var and let become a little different
function fun(){
    //invisible var a;
    //above is what hoisting looks like

    //we generally talk of two other scopes in JS, function scope and block scope -> both of these are local
    let x = 'function'//both are function scoped
    //var a = 'function'//they are in the function and no other blocks of code
    console.log(a)//we would expect a is 'global' here
    
    if(true){
        let x = 'block';//in js we always use the most local declartion of a variable
        var a = 'block';//var does something called variable hoisting
        //var does not have block scope, it only has function and global
        //if you declare a var in a block, it will hoist that declartion to the very top line of the function
        console.log(x)
    }

    console.log(x)

}

fun()