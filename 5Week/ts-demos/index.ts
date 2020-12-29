//index is an entry point to a program

import { Rabbit } from "./rabbit"
console.log("file 1");



//how you declare a vvariable basically hasn't changed
//we now have an option to define the type of a variable manually
//if we don't define it manually, ts will just infer the type

let x:number = 5

let y = 5


let s:string

let b:boolean

let arr:number[] = [0, 10 ,22., 1]

//tuple
//array of fixed size and type
let keyValue: [string, object] = ["name", {}]

let xypos: [number,number]

//can be useful but many times other TS tools will be better
enum Name {

}


//null and undefined

let nu:null

let und:undefined

//new type called never
//never is used to represent a value that will never take place
//like unreachable code in java

//we can define functions

let func: (x)=>void 
//func is a function, it takes in a single param x and returns void


//ts changes how functions work compared to JS
//still no overloading, but TS allows us to enforce functions being called with the correct number of params

function fun1 (x:number, y:number = 1) {
    return x*2
}


//last big type in TS is type any

let js:any = "string"
js= 10

js = null

js = {}


//typescript allows for operations on type definitions
//too major operations it allows
//unions and intersections

let multiArr = ["string", 10]

let multiArr2: (string | number)[]


//the intersection operator is the & symbol and it requries that you are of multiple types and the same time
let z: number & string 
//when we start to define our own types, that when the intersection operator comes into play
//how to define our own types?


let peterRabbit:Rabbit = new Rabbit();

console.log(peterRabbit.sleep())