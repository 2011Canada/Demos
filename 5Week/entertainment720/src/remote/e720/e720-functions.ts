import { e720BaseClient } from "."




export const e720Login = async (username:string, password:string) => {
    let credentials = {
        username,
        password
    }

    try{
        let res = await e720BaseClient.post('/login', credentials)
        
        return res.data
    }catch(e){
        console.log(e);
        if(e.response){
            throw new Error(e.response.data)
        } else {
            throw new Error("OOps Something went wrong?")
        }
        
    }

}