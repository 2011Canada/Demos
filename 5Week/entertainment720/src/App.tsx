import React from 'react';
import logo from './logo.svg';
import './App.css';
import { CanadaBanner } from './components/canada-banner/CanadaBanner';
import { FancyBorder } from './components/fancy-border/FancyBorder';
import { Clicker } from './components/clicker/ClickerFunction';
import { ChuckNorrisJoke } from './components/chuck-norris-joke/ChuckNorrisJoke';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        
        <FancyBorder>
          <CanadaBanner exclam={9} />
        </FancyBorder>
        <FancyBorder>
          <img src={logo} className="App-logo" alt="logo" />
        </FancyBorder>
        <FancyBorder>
         <Clicker/>
        </FancyBorder>
        <FancyBorder>
          <ChuckNorrisJoke/>
        </FancyBorder>
      </header>
    </div>
  );
}

export default App;
