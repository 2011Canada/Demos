import { Grid } from '@material-ui/core'
import React, { useState } from 'react'
import { PurchaseHistoryLine } from '../../../models/PurchaseHistoryLine'

interface DisplayProps {
    phl : PurchaseHistoryLine
}

const PHLDisplay = (props:DisplayProps) =>{
    return (
        <div style={{color:'black'}}>
            {`Paper: ${props.phl.option.type} ${props.phl.option.type}  Amount: ${props.phl.amount}`}
        </div>
    )
}

interface ICartProps {
    lines: PurchaseHistoryLine[]
}

export const ShoppingCart:React.FunctionComponent<ICartProps> = (props) => {
    
    
    let lineDisplay = props.lines.map((line)=>{
        return (
            <Grid xs={4}  item>
                <PHLDisplay phl={line}/>
            </Grid>
        )
    })

    return (
        <Grid container spacing={3}>
            {lineDisplay}
        </Grid>
    )
}