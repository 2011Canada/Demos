

export class Pokemon {
    id:number
    name:string
    weight: number
    picture:string //store the url to the remote photo
    type:[PokemonType, (PokemonType|null)]//some pokemon have one type some have two none have 3+
}

export enum PokemonType {
    Flying = "flying",
    Fire =  "fire",
    Normal = "normal",
    Fighting = "fighting",
    Water = "water",
    Grass = "grass",
    Poison = "poison",
    Electric = "electric",
    Ground = "ground",
    Psychic = "psychic",
    Rock = "rock",
    Ice = "ice",
    Bug = "bug",
    Dragon = "dragon",
    Ghost = "ghost",
    Dark = "dark",
    Steel = "steel",
    Fairy = "fairy"
}