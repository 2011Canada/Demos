import axios from 'axios'

//this is where we config every single request for a certain api
export const pokeapiBaseClient = axios.create({
    baseURL:"https://pokeapi.co/api/v2",
    headers:{
        'Content-Type': "application/json"
    }
})