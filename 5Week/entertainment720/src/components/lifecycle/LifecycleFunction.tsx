import React, { useEffect, useState } from 'react'

interface IComplicatedState {
    message:string
    value:number
}

export const LifecycleFunction:React.FunctionComponent<any> = (props) => {
    const [complicatedState, changeState ] = useState<IComplicatedState>({message:"I am the LifeCycleComponent", value: 0})

    //in a function component all lifecycle effects are achieved through the useEffect hook
    //major rule for a hook is it has to be at the top level of your react function component
    //dont put it in a loop, don't put it in an if statement
    //react takes all of your hooks and combines them into a super hook that it can manage easier

    //the component did mount useEffect
    useEffect(()=>{
        console.log("this will run once, on the very first render")
        changeState((oldState)=>{return{
                ...oldState, 
                message:"I have new data"
            }})
    }, [])
    //the second param of the useEffect is actually really cool
    //it allows us to specify a variable to will trigger the use effect hook
    //it should only be used with state or props
    //if that specified state or props changes, then the useEffect will run after the render

    //for a comp did update
    useEffect(()=>{
        console.log("will run every single render")
    })

    //for componentWillUnmount, use the return calue of the useEffect callback
    useEffect(()=>{
        return ()=>{
            console.log("this will execute when every render to cleanup effects from previous render")
        }
    })


    return (
        <div>
            <p>{complicatedState.message}</p>
        </div>
    )
}