

let numberOfJokes = 2;
//another example of adding an event listener
document.onload = setup()

//"There is no chin behind Chuck Norris’ beard. There is only another fist."

function jokeCardCreator(jokeString) {

    let jokeDiv = document.createElement("div")
    //made the div that has the joke
    jokeDiv.className = "card card-body"
    jokeDiv.innerText = jokeString

    let jokeDivCollapse = document.createElement("div")
    //append that joke to the collapse container
    jokeDivCollapse.appendChild(jokeDiv)

    jokeDivCollapse.className = "collapse"
    numberOfJokes++
    jokeDivCollapse.id = "joke" + numberOfJokes

    let jokeHeader = document.createElement("h5")
    jokeHeader.className = "card-title"
    jokeHeader.innerText = "Joke " + numberOfJokes

    let jokeButton = document.createElement("button")
    jokeButton.className = "btn btn-danger"
    jokeButton.type = "button";
    jokeButton.innerText = "Joke"
    jokeButton.setAttribute("data-bs-toggle", "collapse")
    jokeButton.setAttribute("data-bs-target", "#joke" + numberOfJokes)
    jokeButton.setAttribute("aria-expanded", false)
    jokeButton.setAttribute("aria-controls", "collapseExample")

    let cardBody = document.createElement("div")
    cardBody.appendChild(jokeHeader)
    cardBody.appendChild(jokeButton)
    cardBody.appendChild(jokeDivCollapse)
    cardBody.className = "card-body"

    let chimg = document.createElement("img")
    chimg.src = "./cnorris.jpg"
    chimg.className = "card-img-top"
    chimg.alt = "Chuclk Norris tips his hat at you"

    let totalCard = document.createElement("div")
    totalCard.appendChild(chimg)
    totalCard.appendChild(cardBody)
    totalCard.className = "card cn-joke-card"
    totalCard.style.width = "30vw"

    //search for the div that holds all the cards
    //attach the newly created card
    let cardContainer = document.getElementById("card-container")
    cardContainer.appendChild(totalCard)

}


function setup() {
    //add all my event listeners
    let buyJokeButton = document.querySelector(".button-container button")
    buyJokeButton.addEventListener("click", async () => {
        let joke = await getJokeAsync()
        jokeCardCreator(joke)
    })

    //try setting up an onload event for the html node to call this function

}




//two methods for getting a joke


//one with .then and .catch

function getJokeDotThen() {
    let response = fetch("http://api.icndb.com/jokes/random?limitTo=[nerdy]")
    //the response is currently a promise
    //it is not finished yet
    //someday it will be, but it isn;t this second
    //we need to set up a callback function for when it is done
    let dataPromise = response.then((data) => {
        return data.json().then((parsedData) => {
            return parsedData.value.joke
        })
    }).catch((err) => {
        console.log(err);
    })

    return dataPromise

}

//one with async and await
async function getJokeAsync() {
    try {
        //just wait for the priomise to resolve
        let response = await fetch("http://api.icndb.com/jokes/random?limitTo=[nerdy]")
        //if you want to wait for a promise to respolve we have to make it so the function can be stopped temporarily
        //this means the function will have to be async
        let data = await response.json()

        return data.value.joke
    }catch(e){
        return "oops the joke failed"
    }
}



