import { pokeapiBaseClient } from "."
import { Pokemon } from "../../models/Pokemon";



export const getMultiplePokemon = async (limit:number, offset:number):Promise<Pokemon[]> => {
    try{

        let res = await pokeapiBaseClient.get("/pokemon", {
            params:{
                limit,
                offset
            }
        })

        let pokemons:Promise<Pokemon>[] = res.data.results.map((ele:any) => {
            return getOnePokemon(ele.name)//send all requests at the same time
        });
        console.log(pokemons);
        
        //wait for all requests to finish
        return await Promise.all(pokemons)//takes an array of promises and turns that into a single promise for an array
    } catch(e){
        throw new Error();
    }
}

export const getOnePokemon = async (name:string):Promise<Pokemon> =>{
    try{
        let res = await pokeapiBaseClient.get(`/pokemon/${name}`)

        let pokemon = new Pokemon()
        //do a little data conversion
        pokemon.id = res.data.id
        pokemon.name = res.data.name
        pokemon.picture = res.data.sprites.front_default
        pokemon.weight = res.data.weight
        pokemon.type = [ res.data.types[0].type.name, res.data.types[1] && res.data.types[1].type.name]
        return pokemon
    }catch(e){
        throw new Error()
    }

}