import { Grid } from '@material-ui/core'
import React, { useEffect, useState } from 'react'
import { PaperOption } from '../../../models/PaperOption'
import { getAllPaper } from '../../../remote/DM-paper/paper-functions'
import { PaperDisplay } from './PaperDisplay'


interface IPaperDeckProps {
    buyPaper: (paper:PaperOption, amount:number) => void
}

export const PaperDeck:React.FunctionComponent<IPaperDeckProps> = (props) => {

    const [currentPapers, changeCurrentPapers] = useState<PaperOption[]>([
    ])

    useEffect(()=>{
        const getPaper = async ()=> {
            let papers = await getAllPaper()
            papers && changeCurrentPapers(papers) //execute functions if papers exists and won;t if it doesn't
        }
        getPaper()//how to do async in a use effect
    },[])

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