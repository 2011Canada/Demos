import {dmPaperBaseClient} from './index'
import { PurchaseHistory} from '../../models/PurchaseHistory'
import { toast } from 'react-toastify'



export const makePurchase = async (purchase:PurchaseHistory) => {
    try{
        let res = await dmPaperBaseClient.post('/purchase-history', purchase)


        return res.data
    }catch(e){
        toast.error(e)
    }

}