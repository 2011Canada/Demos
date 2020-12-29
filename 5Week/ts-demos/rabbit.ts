import {ISleepable, IFrolicable} from './interface'//this is from ES6, module system
console.log("file 2");
export class Rabbit implements ISleepable, IFrolicable {

        name:string
        age:number
        numberOfLegs:number


        frolic(){
            return "Little Bunny Fufu, frolicing through the forest"
        }

        sleep(){
            return "Briar Rabbit asleep in the Briar Patch"
        }
}