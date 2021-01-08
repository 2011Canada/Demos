import { Grid } from '@material-ui/core'
import React, { useState } from 'react'
import { PaperOption } from '../../../models/PaperOption'
import { PaperDisplay } from './PaperDisplay'


interface IPaperDeckProps {
    buyPaper: (paper:PaperOption, amount:number) => void
}

export const PaperDeck:React.FunctionComponent<IPaperDeckProps> = (props) => {

    const [currentPapers, changeCurrentPapers] = useState<PaperOption[]>([
        {paperId:1, packageAmount:100, price:10.99, standardSize:"A4", type:"Glossy"},
        {paperId:1, packageAmount:100, price:10.99, standardSize:"A4", type:"Flossy"},
        {paperId:1, packageAmount:100, price:10.99, standardSize:"A4", type:"Lossy"},
        {paperId:1, packageAmount:100, price:10.99, standardSize:"A4", type:"Clyde"}
    ])

    let paperDisplays = currentPapers.map((paper)=>{
        return (
            <Grid xs={4}  item>
                <PaperDisplay paper={paper} buyPaper={props.buyPaper} />
            </Grid>
        )
    })
    
    return (
        <Grid container spacing={3}>
            {paperDisplays}
        </Grid>
    )
}