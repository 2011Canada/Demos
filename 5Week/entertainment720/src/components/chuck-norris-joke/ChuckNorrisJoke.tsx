import React, { useEffect, useState } from 'react'
import { getRandomChuckNorrisJoke } from '../../remote/icndb/get-random-joke'


export const ChuckNorrisJoke: React.FunctionComponent<any> = (props) => {

    const [joke, changeJoke ] = useState("Why isn't there a street named after chuck norris? Because NOBODY crosses Chuck Norris")

    //the second major hook in function components
    //theUseEffect Hook
    //this hook allows us to execute particular code when the component changes
    useEffect(()=>{
        //by default this call back function get executed every single update

        //async is a little strange inside of useEffect but should be easy to follow
        let getJoke = async()=>{
            changeJoke(await getRandomChuckNorrisJoke())
        }

        //call your async function
        getJoke()
    }, [])//if you want a useEffect to take place only once, put an empty array after the cb function


    return (
        <div>
            <p>{joke}</p>
            <button onClick={async ()=>{changeJoke(await getRandomChuckNorrisJoke())}}>Get Joke</button>
        </div>
    )
} 