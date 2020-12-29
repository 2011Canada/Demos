

export const getRandomChuckNorrisJoke = async ():Promise<string> => {
    try{
        let response = await fetch("http://api.icndb.com/jokes/random?limitTo=[nerdy]")

        let data = await response.json();
        
        return data.value.joke
    } catch(e){
        console.log(e);
        return "Oops something went wrong"
    }
    

}