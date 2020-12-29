import React from 'react';
import logo from './logo.svg';
import './App.css';
import { CanadaBanner } from './components/canada-banner/CanadaBanner';
import { FancyBorder } from './components/fancy-border/FancyBorder';
import { Clicker } from './components/clicker/ClickerFunction';
import { ChuckNorrisJoke } from './components/chuck-norris-joke/ChuckNorrisJoke';
import { BrowserRouter as Router, Link, Route, Switch } from 'react-router-dom'

function App() {
  return (
    <div className="App">
      <Router>
        {/* provides access to history location and match
      allows links to function and route components to function */}


        <header className="App-header">

          <FancyBorder>
            <CanadaBanner exclam={9} />
          </FancyBorder>
          <Switch>
            {/* makes it so only a single route inside is ever rendered
            it always choose the first route found that matches the path, put generic paths
            towards the bottom */}
            <Route exact path="/" render={()=><h1>I am the Home Component</h1>}/>
            <Route path="/logo">
              {/* children of a route comp get rendered at that path */}
              <FancyBorder>
                <img src={logo} className="App-logo" alt="logo" />
              </FancyBorder>
            </Route>
            <Route path="/clicker" component={Clicker} />
            {/* the component prop is used to specifyu a component to render at the path
          the component is automatically provided history location and match as props */}
            <Route path="/joke" render={() => {
              return (
                <FancyBorder>
                  <ChuckNorrisJoke />
                </FancyBorder>)
            }} />
            {/* the render prop method takes a function to be executed as the render function */}
            
          </Switch>
          
        </header>
        <Link to="/logo"> Picture</Link>
        <br></br>
        <Link to="/clicker"> Clicker</Link>
        <br></br>
        <Link to="/joke"> Joke</Link>
      </Router>
    </div>
  );
}

export default App;
