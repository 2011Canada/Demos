import { Button, Card, CardContent, Chip, FormControl, InputLabel, makeStyles, MenuItem, Select, Typography } from '@material-ui/core'
import React, { useState } from 'react'
import { PaperOption } from '../../../models/PaperOption'

interface IPaperDisplayProps {
    paper: PaperOption
    buyPaper: (paper:PaperOption, amount:number) => void
}

const useStyles = makeStyles({
    root: {
        minWidth: 275,
        maxWidth: 400,
    },
    picture: {
        height: 150
    },
    chip: {
        backgroundColor: '#705848'
    }
});


export const PaperDisplay: React.FunctionComponent<IPaperDisplayProps> = (props) => {

    const classes = useStyles()

    const [orderAmount, changeOrderAmount] = useState<number>(1)

    const updateOrderAmount = (e: any) => {
        changeOrderAmount(e.target.value)
    }

    return (
        <Card className={classes.root}>
            <CardContent>
                <Typography variant="h5" component="h3">{props.paper.type} {props.paper.standardSize}</Typography>
                <Chip className={classes.chip} label={`Package Size: ${props.paper.packageAmount}`} />
                <Chip className={classes.chip} label={`Price: ${props.paper.price}`} />
                <br></br>
                <Button variant="contained" color="primary" onClick={()=>props.buyPaper(props.paper, orderAmount)}>
                    Buy
                </Button>
                <FormControl >
                    <InputLabel id="amount-select-label">Amount</InputLabel>
                    <Select
                        labelId="amount-select-label"
                        id="amount-Select"
                        value={orderAmount}
                        onChange={updateOrderAmount}
                    >
                        <MenuItem value={1}>1</MenuItem>
                        <MenuItem value={2}>2</MenuItem>
                        <MenuItem value={3}>3</MenuItem>
                        <MenuItem value={4}>4</MenuItem>
                        <MenuItem value={5}>5</MenuItem>
                        <MenuItem value={6}>6</MenuItem>
                        <MenuItem value={7}>7</MenuItem>
                        <MenuItem value={8}>8</MenuItem>
                        <MenuItem value={9}>9</MenuItem>
                    </Select>
                </FormControl>
            </CardContent>
        </Card>
    )
}