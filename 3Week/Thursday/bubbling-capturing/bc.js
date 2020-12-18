let blue = document.getElementById("1")
let green = document.getElementById("2")
let red = document.getElementById("3")
let purple = document.getElementById("4")



blue.addEventListener("click", (e)=>{
    //the param e is the event object that was generated
    setTimeout(()=>{
        if(blue.style.backgroundColor){
            blue.style.backgroundColor = ""
        } else {
            blue.style.backgroundColor = "blue"
        }
    }, 2000)//classic async callback function
})//it makes it capture instead

green.addEventListener("click", (e)=>{
    //the param e is the event object that was generated
    setTimeout(()=>{
        if(green.style.backgroundColor){
            green.style.backgroundColor = ""
        } else {
            green.style.backgroundColor = "green"
        }
    }, 1500)//classic async callback function
})

red.addEventListener("click", (e)=>{
    //the param e is the event object that was generated
    setTimeout(()=>{
        if(red.style.backgroundColor){
            red.style.backgroundColor = ""
        } else {
            red.style.backgroundColor = "red"
        }
    }, 1000)//classic async callback function
})

purple.addEventListener("click", (e)=>{
    //the param e is the event object that was generated

    e.stopPropagation()//if you call stop propagation on an event it won;t bubble or capture
    //this is what we do most of the time in react

    setTimeout(()=>{
        if(purple.style.backgroundColor){
            purple.style.backgroundColor = ""
        } else {
            purple.style.backgroundColor = "purple"
        }
    }, 500)//classic async callback function
})