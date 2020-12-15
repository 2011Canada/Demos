function compare(a,b){
    console.log(`
        a is ${a} and has type ${typeof a} 
        b is ${b} and has type ${typeof b} 
        a == b ${a==b}
        a === b ${a===b}`)
}




compare(10,'10')

compare(null,undefined)

compare ({},[])

compare (0,false)

compare(NaN, NaN)//NaN does not equal itself
//the only way to check of NaN is afunction called isNaN(var) //true or false depending