import React, { Component } from 'react'
import './App.css'
import Categories from './components/Categories'

class App extends Component {
  state = {
    categories: []
  }

  componentDidMount() {
    fetch("/categories")
        .then(response => response.json())
        .then(data => this.setState({ categories: data }))
        .catch(err => console.log(err))
  }

  render() {
    return (
      <div className="App">
        <Categories categories={this.state.categories}/>
      </div>
    );
  }
}

export default App;
