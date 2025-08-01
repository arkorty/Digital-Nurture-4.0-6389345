import React from 'react';
import Posts from './Posts'; // Import the Posts component
import './App.css'; // Assuming you have an App.css if needed

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h2>Check out the latest blog posts!</h2>
      </header>
      <main>
        <Posts />
      </main>
    </div>
  );
}

export default App;