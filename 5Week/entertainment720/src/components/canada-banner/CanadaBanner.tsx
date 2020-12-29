//two ways to make a componenet as a function or as a class
//components have to follow some specific rules

//rule number zero, you need to import React from react
import React from 'react'

//rule number one, your component must start with a captial letter
//has to do with the tsx/jsx compiler ( babel ) 
//if its lowercase the compiler assumes its a normal html element
//uppercase assumes it a react element
export const CanadaBanner:React.FunctionComponent = (props:any ) => {
    // rule number two, you must return some jsx as a function
    return (
        <div>
            <h1>Canada #1!</h1>
            <h2>Canada is Cold</h2>
        </div>
        //rule 3 all of your jsx that return needs to be within a single root tag
        //CAN'T return 2 different tags on the same level
    );//js semicolon injection is a little tricky with jsx
}