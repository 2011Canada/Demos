
let mathFunc = (a,b,c) => {
    console.log(`   a = ${a} 
    b = ${b}
    c= ${c}`)
    return (a*b)/c
}//function literal


console.log(mathFunc())
//im going to call my function with 0 params, but it says it has 3, will this work?
//JS does not support Overloading
//it kind of supports overriding but its secretly just shadowing

console.log(mathFunc(1))

//in js we can assign default values for params
// this is only for default values, default is only if it is not provided
let mathFunc2 = (a,b,c=1) => {
    console.log(`   a = ${a} 
    b = ${b}
    c= ${c}`)
    return (a*b)/c
}
mathFunc2()

mathFunc2(1,2,2,2,33,56)

let avg = (a,b, ...params)=>{
    let total = a+b;
    for(let i =0; i< params.length; i++){
        total += params[i]
    }
    return total/params.length +2
}


console.log(avg(1,5,68,78,99,100,4000,567));