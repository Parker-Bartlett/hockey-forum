import React, { Component } from 'react'
import PropTypes from 'prop-types'
import Category from './Category'

export default class Categories extends Component {
  render() {
    return this.props.categories.map((category) => (
        <Category key={category.id} category={ category } 
        viewSingleCategory={this.props.viewSingleCategory}
        deletePost={this.props.deletePost}
        addComment={this.props.addComment}
        updateCategory={this.props.updateCategory}/>
    ))
  }
}

// Proptypes
Categories.propTypes = {
    categories: PropTypes.array.isRequired,
    deletePost: PropTypes.func.isRequired,
    addComment: PropTypes.func.isRequired
}


