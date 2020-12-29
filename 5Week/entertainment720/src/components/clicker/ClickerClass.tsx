import React from 'react'


export class Clicker extends React.Component<any,any> {
    constructor(props:any){
        super(props)
        //the only time we get to directly set state is when initializing it
        this.state = {
            clicks:0,
            message:"Watch this not change"
        }
    }


    //functions have their own this keyword unless the are anonymous functions
    incrementClicks = ()=> {
        //in here, the body of an anonymous function
        //this refers to the class
        let clicks = this.state.clicks +1
        //the only way to update state
        this.setState({
            ...this.state,//copy all of the old values into the new state value
            //without the spread it would be easy to lose bits of state, like the message
            clicks//overwrite with the specific new values
        })
    }


    //you need to override render 
    render(){
        //it returns jsx
        return (
            <div>
                <p>Number of Clicks : {this.state.clicks}</p>
                <button type="button" onClick={this.incrementClicks} >Click </button>
            </div>
        )
    }

}