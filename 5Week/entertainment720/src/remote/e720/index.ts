//this is where I will set up axios for the e720 api
//we set up axios for each different api that we use
//it gives us an object that we can use to easily connect to an api

import axios from 'axios'

//this is where we config every single request for a certain api
export const e720BaseClient = axios.create({
    baseURL:"http://ec2-3-226-237-188.compute-1.amazonaws.com:8090/e720",
    headers:{
        'Content-Type': "application/json"
    }
})