
import axios from 'axios'

//this is where we config every single request for a certain api
export const dmPaperBaseClient = axios.create({
    baseURL:"http://localhost:8080",
    headers:{
        'Content-Type': "application/json"
    }
})