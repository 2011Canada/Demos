import React, { useState } from 'react'

export const Clicker:React.FunctionComponent<any> = (props) => {
    //functions don't have direct access to the state api
    //however access is provided to functions through a special piece of code called a hook
    //these "hooks" allow functions to "hook" into the traditional APIs
    //the one used most often is the useState hook
    let [clicks, changeClicks] = useState(1);
    //this declaration does a lot of different things

    //useState is a function that takes in an initial value for a particular piece of state
    //it then returns an array that has two values
    //the first of those value [0] is a variable that represent the current value of state
    //the second of those values [1] is a function that when called updates the state to a new value
    
    let [message, changeMessage] = useState("default message")

    const incrementClicks = ()=>{//this function
        changeClicks(clicks + clicks)//calls a function with a specific value
    }
    if(clicks > 10 && message !== "Wow thats a lot of clicks" ){
        changeMessage("Wow thats a lot of clicks")
    }

    

    return (
            <div>
                <p>Number of Clicks : {clicks}</p>
                <p>{message}</p>
                <button type="button" onClick={incrementClicks} >Click </button>
            </div>
    )
}