import React, { Component } from 'react'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import './App.css'
import Categories from './components/Categories'
import Header from './components/layout/Header'

class App extends Component {
  state = {
    posts: [],
    categories: []
  }

  componentDidMount() {
    fetch("/categories")
        .then(response => response.json())
        .then(data => this.setState({ categories: data }))
        .catch(err => console.log(err))
  }

  viewSingleCategory = (id) => {
    console.log(id)
    fetch(`/${id}/posts`)
      .then(response => response.json())
      .then(data => this.setState({posts:data}))
      .catch(err => console.log(err))
      return <Header />
  }

  deletePost = (id) => {
    fetch(`/comment/delete/${id}`, {method: 'delete'})
    .then(res => res.json())
      .then(data => {
        this.setState({categories: data})
      })
      .then(window.location.reload())
      .catch(err => console.log(err))
  }

  addComment = (id, state) => {
    fetch(`/comment/add/${id}`, {method: 'POST', body: JSON.stringify(state)})
      .then(data => {
        this.setState({categories: data})
      })
      .then(window.location.reload())
      .catch(err => console.log(err))
  }

  render() {
    return (
      <Router>
        <div className="App">
          <Header />
          <Route exact path="/" render={props => (
            <React.Fragment>
              <Categories categories={this.state.categories}
              viewSingleCategory={this.viewSingleCategory} 
              deletePost={this.deletePost}
              addComment={this.addComment}/>
            </React.Fragment>
          )} />
        </div>
      </Router>
    );
  }
}

export default App;
