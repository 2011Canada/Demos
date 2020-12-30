import React from 'react'
import { Redirect } from 'react-router'
import { User } from '../../models/User'


interface IUserAuthRouteProps {
    currentUser:User
}

const UserAuthRoute:React.FunctionComponent<IUserAuthRouteProps> = (props) => {
    return (
        (props.currentUser) ?
            <>
            {props.children}
            </>
            :
            <Redirect to="/login"/>
    )
}


//HOC
//just a function
const protectComponent = (currentUser:User, component:any) => {
    //return a new component

    return UserAuthRoute({currentUser,children:component()})
    
}

export default protectComponent