import React from 'react'


export const FancyBorder:React.FunctionComponent<any> = (props) =>{

    return (
        <div style={{border: "2px solid cadetblue" }}>
            <div style={{border: "2px dashed cadetblue",
                        margin:"3px" }}>
                    {props.children}
            </div>
        </div>
    )
}