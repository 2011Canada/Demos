

//encapsulation in js is acheived through the closure
//technically if you can declare a function you need to support closures in some manner

//in java you can only make a closure on an effectively final variable
//in js you can make a closure on anything

//we can use closure for getters and setters

function Car(make, model, year){
    this.getMake = ()=>{
        return make
    }
    this.setMake = (m) =>{
        make = m
    }
    this.getModel = ()=>{
        return model
    }
    this.setModel = (m) =>{
        model = m
    }
    this.getYear = ()=>{
        return year
    }
    this.setYear = (y) =>{
        year = y
    }
}

let myCar = new Car("BMW", "5 Series", )

console.log(myCar.getMake())
myCar.setMake("Ford")

console.log(myCar.getMake())








//imagine you are building an api
//you want to check peoples permissions to take a specific action
//there many different roles in an api
//admin, customer, users ,employees, developers
//bad way of writing permission checking to to write a fuinction for each subset of the roles

//some action can only be for admin and devs

//some is admin devs and customers

//some is everybody

//we can write a factory function that returns a function approving certain roles

function roleCheckerBuilder(roles){//roles is getting a closure

    return ()=>{
        //this is our enhanced for loop for going through collections of data
        for( let role of roles){
            if(currentUser.role == role){
                console.log("you are allowed in")
            }
        }
        console.log("You don't have the correct permissions")
    }

}


let currentUser = {
    name:"Henry",
    role:"developer"
}

//sepcial action, read employee's social security number
let roleChecker = roleCheckerBuilder(["CEO", "HR", "Admin"])


roleChecker()

//RBAC
// Role Based Access Control

//correct way to build permissions
//you tie a particular action to a permission
//you group relaterd permissions into a role ( gernerally around workflow)
//you grant users one or more roles related to what they have to do, while also minimizing their privilages