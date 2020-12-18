let stringOfJson = '{"name":"alec", "age":10, "language":"javascript"}'


let jsObj = JSON.parse(stringOfJson)

jsObj.name = "Henry"
console.log(jsObj);

let obj = {
    make:"BMW",
    model:"5",
    year:"1997"
}

let string = JSON.stringify(obj)

console.log(string);