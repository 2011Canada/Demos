import React from 'react'

interface ILCCState {
    message:string
}

export class LifecycleClass extends React.Component<any,ILCCState> {
    constructor(props:any){
        super(props)
        console.log("First Part of Mounting Phase");
        this.state = {
            message: "I am the Lifecycle Component"
        }

    }

    componentDidMount(){
        //this function will be called at the end of the mounting phase
        //it can potentially trigger a re render
        //most commonly used to fetch data that component will need to display
        console.log("Componenent has mounted")
        //simulate data fetching
        this.setState({
            ...this.state,
            message:"I have new data now"
        })//this is going to trigger immediately another render
    }

    componentDidUpdate(){
        //this is called after each and every update the component
        //not the very first one, that is mounting

        //be very careful because if it triggers a re render it very well might cause an infinite loop
        //sometimes used when fetching data like if the user hits the next button on a table data to see the next page
        //can be uysed for a lot of different things
        console.log("Component updated")

    }


    componentWillUnmount () {
        // if the component is already unmounted?
        //called right before we delete the component
        //its used for clean up
        //mutli player tic tac toe game
        //set up a connection between the players
        //you could clean up that connction here
        console.log("Component is about to be deleted")
    }

    render() {
        return (
            <div>
                <p>{this.state.message}</p>
            </div>
        )
    }






}