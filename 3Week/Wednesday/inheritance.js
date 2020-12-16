

let child = {
    name:"child",
    type:"Radical"
}//right now child inherits from Object


let parent = {
    name:"parent",
    job:"Taking care of child"
}//right now parent inherits from Object


console.log(child.job);//;should be undefined

Object.setPrototypeOf(child, parent)

console.log(child.job);//should be "taking care of child"
//we don't find the member job on child so we look at its prototype
//its prototype is now parent and parent has a job

console.log(child.type)
console.log(parent.type)
console.log(child.name)

let superObject = Object.getPrototypeOf(parent)
//Technically it this Object.prototype 
superObject.pet = "a cute doggy"

console.log(child.pet)
console.log(parent.pet)
console.log({}.pet)
//DON'T ADD MEMBERS TO THE SUPER OBJECT
//you are asking for a conflict when using any library ever



class Parent{
    name
    job
    constructor(name, job){
        this.name = name
        this.job = job
    }
}

class Child extends Parent{
    //every time I make a child it automatically updates the prototype for me
}