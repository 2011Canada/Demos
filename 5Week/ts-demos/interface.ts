
export interface IFrolicable {
    frolic:()=>string
}

export interface ISleepable {
    sleep:()=>string
}

let myObj:IFrolicable & ISleepable = {
    frolic:()=>{
        return "The hills are alive"
    },
    sleep:()=>{
        return "Yawn I sure am tired"
    }
}