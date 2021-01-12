import { toast } from "react-toastify";
import { dmPaperBaseClient } from ".";
import { PaperOption } from "../../models/PaperOption";




export const getAllPaper = async ():Promise<PaperOption[]> => {
    try{
        let res = await dmPaperBaseClient.get('/paper')

        return res.data
    }catch(e){
        toast.error(e)
    }
}