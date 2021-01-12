import { Button, Grid } from '@material-ui/core'
import React, { useState } from 'react'
import { PurchaseHistory } from '../../../models/PurchaseHistory'
import { PurchaseHistoryLine } from '../../../models/PurchaseHistoryLine'
import { FancyBorder } from '../../fancy-border/FancyBorder'

interface DisplayProps {
    phl: PurchaseHistoryLine
}

const PHLDisplay = (props: DisplayProps) => {
    return (
        <div style={{ color: 'black' }}>
            {`Paper: ${props.phl.option.type} ${props.phl.option.type}  Amount: ${props.phl.amount}`}
        </div>
    )
}

interface ICartProps {
    lines: PurchaseHistoryLine[]
    submitOrder: () => void
}

export const ShoppingCart: React.FunctionComponent<ICartProps> = (props) => {


    let lineDisplay = props.lines.map((line) => {
        return (
            <Grid xs={4} item>
                <PHLDisplay phl={line} />
            </Grid>
        )
    })

    return (
        <div>
            <Grid container spacing={3}>
                {lineDisplay}
            </Grid>
            <FancyBorder>
                <Button onClick={props.submitOrder}>Checkout</Button>
            </FancyBorder>
        </div>
    )
}