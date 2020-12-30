import { Button, Grid, TextField } from '@material-ui/core'
import React, { SyntheticEvent, useState } from 'react'
import { Redirect } from 'react-router'
import { toast } from 'react-toastify'
import { User } from '../../models/User'
import { e720Login } from '../../remote/e720/e720-functions'


interface ILoginProps{
    updateCurrentUser: (u:User) => void
    currentUser:User
}

export const LoginForm: React.FunctionComponent<ILoginProps> = (props) => {
    const [username, changeUsername] = useState("")
    const [password, changePassword] = useState("")
    

    const handleUsernameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        changeUsername(e.target.value)
    }

    const handlePasswordChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        changePassword(e.target.value)
    }

    //synthetic even is a type provided by react for standardizing different browser events
    const submitLogin = async (e:SyntheticEvent) => {
        //wwhat does submit normally do?
        e.preventDefault()
        //send username and password to a remote location to get the user info/auth token
        try {
            let user = await e720Login(username, password)
            props.updateCurrentUser(user)
        }catch(e){
            changePassword("")
            toast.error(e.message)
        }
    }

    return (
        // conditional rendering
        (props.currentUser) ? //have an if statement or a ternary and sometimes render one thing or another
        <Redirect  to='/clicker'/>
        :
        <form onSubmit={submitLogin}>
            <Grid
                container
                direction="column"
                justify="flex-start"
                alignItems="center"
                spacing={2}
            >
                <Grid item>
                    <TextField value={username} onChange={handleUsernameChange} id="username" label="Username" variant="outlined" autoComplete="off" />
                </Grid>
                <Grid item>
                    <TextField value={password} onChange={handlePasswordChange} id="password" label="Password" variant="outlined" type="password" />
                </Grid>
                <Grid item>
                    <Button type="submit" variant="outlined">Submit</Button>
                </Grid>
                    
            </Grid>
        </form>
    )


}