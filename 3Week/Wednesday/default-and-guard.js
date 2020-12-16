
//I want to check if the currently logged in user has role Admin


let currentUser

function checkAdmin(){

    let userRole = currentUser && currentUser.role
    //if currentUser is not defined, userRole will equal undefined
    //if currentUser is truthy, userRole will equal currentUser.role whatever value that is
    if( userRole == "admin"){
        console.log("Whoopee");
    }else {
        console.log("I'm sad");
    }
}

checkAdmin();



//we are trying to connecto to a database
//and the user for a url
//and a username and a password

let userInput = {
    url:"amazon.rds.aklssjhfd.aws.com",
    password:"SQLRulez"
}


let url = userInput.url || "jdbc:postgres://locahost:5432/postgres"
let username = userInput.username || "postgres"
let password = userInput.password || "password"


console.log(url,username,password)

