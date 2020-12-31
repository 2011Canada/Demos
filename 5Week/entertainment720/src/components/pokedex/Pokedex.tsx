import { Button, Grid } from '@material-ui/core'
import React, { useEffect, useState } from 'react'
import { Pokemon, PokemonType } from '../../models/Pokemon'
import { getMultiplePokemon } from '../../remote/pokeapi/pokemon-functions'
import protectComponent from '../protected-route/UserAuthRoute'
import { PokemonDisplay } from './PokemonCard'



export const Pokedex:React.FunctionComponent<any> = (props)=>{

    const [currentPokemons, changeCurrentPokemons] = useState<Pokemon[]>([{name:"bulbasaur", id:1, weight:20, picture:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", 
    type: [PokemonType.Grass, PokemonType.Poison]},{name:"bulbasaur", id:2, weight:20, picture:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", 
    type: [PokemonType.Grass, PokemonType.Poison]},{name:"bulbasaur", id:3, weight:20, picture:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", 
    type: [PokemonType.Grass, PokemonType.Poison]},{name:"bulbasaur", id:4, weight:20, picture:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", 
    type: [PokemonType.Grass, PokemonType.Poison]},{name:"bulbasaur", id:5, weight:20, picture:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", 
    type: [PokemonType.Grass, PokemonType.Poison]},{name:"bulbasaur", id:6, weight:20, picture:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", 
    type: [PokemonType.Grass, PokemonType.Poison]},{name:"bulbasaur", id:7, weight:20, picture:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", 
    type: [PokemonType.Grass, PokemonType.Poison]},{name:"bulbasaur", id:8, weight:20, picture:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", 
    type: [PokemonType.Grass, PokemonType.Poison]},{name:"bulbasaur", id:9, weight:20, picture:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", 
    type: [PokemonType.Grass, PokemonType.Poison]},{name:"bulbasaur", id:10, weight:20, picture:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", 
    type: [PokemonType.Grass, PokemonType.Poison]}])

    const [limit, changeLimit] = useState<number>(10)
    const [offset, changeOffset] = useState<number>(0)


    useEffect(()=>{
        const getPokemon = async ()=>{
            let pokemons = await getMultiplePokemon(limit,offset)
            console.log(pokemons);
            changeCurrentPokemons(pokemons)
        }
        getPokemon()

    },[offset,limit])



    //how to take a pokemon and turn it into a display component
    let pokemonDisplays = currentPokemons.map((pokemon)=>{
        return (
            <Grid xs={4}  item>
                <PokemonDisplay pokemon={pokemon} />
            </Grid>
        )
    })


    return (
        // React Fragment, a fake tag to make react happy
        //works like a real tag, but disappears once you reach the DOM
        <>
        <Grid container spacing={3}>
            {pokemonDisplays}
        </Grid>
        <Button variant="outlined" onClick={()=>changeOffset((offset-limit <0 )? 0 : offset-limit)}>Previous Page </Button>
        <Button variant="outlined" onClick={()=>changeOffset(offset+limit)}>Next Page </Button>
        </>
    )
}

export default protectComponent(Pokedex)