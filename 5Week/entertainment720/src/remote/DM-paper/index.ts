
import axios from 'axios'

//this is where we config every single request for a certain api
export const dmPaperBaseClient = axios.create({
    baseURL:"http://ec2-3-239-17-176.compute-1.amazonaws.com:10000",
    headers:{
        'Content-Type': "application/json"
    }
})