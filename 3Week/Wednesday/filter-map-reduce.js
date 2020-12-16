let data = [
    {
        name:"Henry",
        age:55,
        color:"pink",
        country:"Canada"
    },
    {
        name:"matt",
        age:14,
        color:"blue",
        country:"Canada"
    },
    {
        name:"Peter",
        age:29,
        color:"Black",
        country:"Florida"
    },
    {
        name:"Alec",
        age:187,
        color:"Burgundy",
        country:"USA"
    },
    {
        name:"Colin",
        age:23,
        color:"Grey",
        country:"Canada"
    }
]




//people at revature

//the average age of revature employees in all of our physical locations

//all of theses, except map which is a little different
//take in a callback function with the same signature
//(element itself, index of the element in the array, the original array)
//three params is gets called with
//most of the time you only need the first one
let filteredData = data.filter((ele)=>{
    if(ele.country == "Canada"){
        return true
    }else{
        return false
    }
})

let mappedData = filteredData.map((ele)=>{
    return ele.age//whataver I return becoms the new element
    //I no longer care about any data that isn't your age for this particular process
})

console.log(filteredData);
console.log(mappedData)


let reducedValue = mappedData.reduce((prev, ele)=>{
    return prev + ele
}, 0)/(mappedData.length)

console.log(reducedValue)


data.filter((ele)=>{
    if(ele.country == "Canada"){
        return true
    }else{
        return false
    }
}).map((ele)=>{
    return ele.age//whataver I return becoms the new element
    //I no longer care about any data that isn't your age for this particular process
}).reduce((prev, ele)=>{
    return prev + ele
}, 0)/(mappedData.length)