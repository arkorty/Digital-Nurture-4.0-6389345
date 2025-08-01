import React, { Component } from 'react';
import './App.css'; 
import CurrencyConvertor from './CurrencyConvertor'; 
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0
    };
    this.handleIncrement = this.handleIncrement.bind(this); 
    this.handleDecrement = this.handleDecrement.bind(this);
    this.handleSyntheticClick = this.handleSyntheticClick.bind(this);
  }
  handleIncrement() {
    this.setState(prevState => ({
      counter: prevState.counter + 1
    }));
    this.sayHello(); 
  }

  handleDecrement() {
    this.setState(prevState => ({
      counter: prevState.counter - 1
    }));
  }
  incrementValue() {
    this.setState(prevState => ({
      counter: prevState.counter + 1
    }));
  }

  sayHello() {
    alert("Hello! member");
  }

  sayWelcome(message) { 
    alert("Welcome");
  }

  handleSyntheticClick(event) { 
    console.log("Synthetic Event Type:", event.type);
    alert("I was clicked");
  }

  render() {
    return (
      <div className="App" style={{
        backgroundColor: 'white',
        minHeight: '100vh',
        padding: '20px',
        fontFamily: 'sans-serif', 
        fontSize: '16px' 
      }}>
        <header className="App-header" style={{
          textAlign: 'left',
          margin: '0 auto', 
          maxWidth: '800px' 
        }}>
          
          <h1>Counter: {this.state.counter}</h1> 
          <button onClick={this.handleIncrement} style={{ marginBottom: '5px' }}>Increment</button>
          <br />
          <button onClick={this.handleDecrement} style={{ marginBottom: '5px' }}>Decrement</button>
          <br />
          <button onClick={() => this.sayWelcome("welcome")} style={{ marginBottom: '5px' }}>
            Say welcome
          </button>
          <br />
          <button onClick={this.handleSyntheticClick} style={{ marginBottom: '5px' }}>
            Click on me
          </button>
          <br />
          <CurrencyConvertor />
        </header>
      </div>
    );
  }
}

export default App;