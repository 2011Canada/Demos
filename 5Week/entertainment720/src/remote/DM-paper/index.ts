
import axios from 'axios'

//this is where we config every single request for a certain api
export const dmPaperBaseClient = axios.create({
    baseURL:"http://localhost:10000",
    headers:{
        'Content-Type': "application/json"
    }
})