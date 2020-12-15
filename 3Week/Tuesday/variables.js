//how we go about declaring variables in JS
//for most of JS I'm just going to write notes in comments
//the basics of js are very similar to java

//in JS we have 3 different way to declare a variable ( technically 4 but one is really bad)

//var is the original wat to declare a variable in js
//you should never use var
//var has some strange behaviour that has been rectified by the ES6 let keyword
//(hoisting) 
var x;

//the let keyword was added it ES6, it functions just the same as var does
//but it has an additional variable scope so that it doesn't have a hoisting problem
let a;

//just like let but once you assign a value it can't be reassigned another value
//like the final keyword in java
const c = 'const'//need to assign right away


//the 4th version is technically you don't need a keywrod at all, but this is areally bad and confusing
//never do this
d = 10;

a = 10;
console.log(a);
a += "a new string";
console.log(a);

x = ['A string']
let y = a / x//a is a string and x is an array with a string in it
//js will still try and divide them as a mathmatical operation
console.log(y);


a = 10;
y = '10';

console.log([4,5,6] + [1,2,3]);


//semicolon injection, it identifies where a statement should end and puts a semicolon there for you
//there are a couple occasions where this fails, but its generally very good