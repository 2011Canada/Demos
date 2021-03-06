import React, { useState } from 'react'
import { Route, Switch, useRouteMatch } from 'react-router'
import { Link } from 'react-router-dom'
import { toast } from 'react-toastify'
import { PaperOption } from '../../models/PaperOption'
import { PurchaseHistoryLine } from '../../models/PurchaseHistoryLine'
import { makePurchase } from '../../remote/DM-paper/purchase-history-functions'
import { FancyBorder } from '../fancy-border/FancyBorder'
import { PaperDeck } from './paper-store/PaperDeck'
import { ShoppingCart } from './shopping-cart/ShoppingCart'


export const StoreFront: React.FunctionComponent<any> = (props) => {
    const match = useRouteMatch()
    const [purchaseLines, changePurchaseLines] = useState<PurchaseHistoryLine[]>([])
    
    const buyPaper = (paper:PaperOption, amount:number) => {
        changePurchaseLines((oldLines)=>{
            //this line of code is max Javascript
            //return a new array with all values of the old array, and one new object
            return [...oldLines, {lineId:0, option:paper, amount}]
        })
    }


    const submitOrder = async () => {
        let success = await makePurchase({purchaseHistoryId:0,totalPurchase:purchaseLines, purchaser: {name:"Olivia", customerId:1}})
        if(success){
            toast.success(`New Order ${success.purchaseHistoryId} Created`)
            changePurchaseLines([])
        }

    }


    return (
        <>
            <Switch>
                <Route path={`${match.path}/paper-store`}>
                    <PaperDeck buyPaper={buyPaper}/>
                </Route>
                <Route path={`${match.path}/shopping-cart`}>
                    <ShoppingCart lines={purchaseLines} submitOrder={submitOrder}/>
                </Route>
            </Switch>
            <FancyBorder>
                <br></br>
                <Link to={`${match.path}/paper-store`}>Paper Store</Link>
                <br></br>
                <Link to={`${match.path}/shopping-cart`}> Shopping Cart</Link>
            </FancyBorder>
        </>
    )
}