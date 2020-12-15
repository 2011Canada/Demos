//at the end of day pretty much everything in js is an object
//all of our primitives have corresponding object types and js manages casting back and forth between them

//what do objects look like in js?
//an object is just a collection of key value pairs

let x = {
    name:"Alec",
    job:"Senior Trainer",
    favoriteSoup:"Gumbo",
    walk:()=>{console.log("Ehh I'm walking here")},
    //no real difference between functions and fields
}//an object literal, one of 2 ways to make an object

console.log(x)
x.walk()
console.log(x.random);
x.random = "a new value"
console.log(x.random);
//objects are dynamic in js
//we can add and remove fields whenever we want 
delete x.job // job is gone
console.log(x.job);

//how can you make an object in js?

//as above you can use an object literal
//very common, very dynamic

//second way 
//less common and less dynamic
//use a function as a constructor

//a function is an object
//objects have a this keyword to refer to themselves
//objects can dynamically add or remove fields
//a function could use its this keyhword to give itself fields
//we can use the new keyword with a function to get a copy of it
//all of the above combines to making a constructor for an object

function Car(make){
   this.make = make;
   this.model = "5 Series";
   this.year = "1997";
   this.owner =  null ;
}

let myCar = new Car();

console.log(myCar.owner);



//function constructors are kind of weird
//the introduced a new way in es6
//they added "classes"
//a class in js looks a lot like a class in java or c#
//secretly its still just function constructors
// syntactic suger

class Student {

    name
    classes
    gpa

    constructor(name, classes, gpa = 4){
        this.name = name,
        this.classes = classes,
        this.gpa = gpa
    }

    talk(){
        console.log(`Hello World My name is ${this.name}`);
    }
}


let Andy = new Student("Andy", ["Computers", "sciences"])

console.log(Andy);
Andy.talk()