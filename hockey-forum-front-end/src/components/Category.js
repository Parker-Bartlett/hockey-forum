import React, { Component } from 'react'
import PropTypes from 'prop-types'
import Post from './Post'
import UpdateCategoryTitle from './UpdateCategoryTitle'

export default class Category extends Component {
  render() {
    return (
      <div>
        <h2 style={categoryStyle}>
            {this.props.category.title}
        </h2>
        <UpdateCategoryTitle updateCategory={this.props.updateCategory} categoryId={this.props.category.id}/>
        <Post category={this.props.category}
        deletePost={this.props.deletePost}
        addComment={this.props.addComment}/>
      </div>
    )
  }
}


const categoryStyle = {
    backgroundColor: '#555',
    color: 'white',
    textAlign: 'center',
    padding: '10px',
}


// PropTypes
Category.propTypes = {
    category: PropTypes.object.isRequired,
    deletePost: PropTypes.func.isRequired,
    addComment: PropTypes.func.isRequired
}

