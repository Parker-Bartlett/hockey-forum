import React, { Component } from 'react'
import PropTypes from 'prop-types'
import Comment from './Comment'
import AddComment from './AddComment';

export default class Post extends Component {
  render() {
    return this.props.category.posts.map((post) => (
        <div style={postStyle}>
           <h4>{post.title}</h4>
           <button onClick={this.props.deletePost.bind(this, post.id)}>x</button>
           <p>{post.body}</p>
           <AddComment key={post.id} post={post} addComment={this.props.addComment}/>
           <Comment post={post} deletePost={this.props.deletePost}/>
        </div>
    ))
  }
}

const postStyle = {
    margin: '15px',
    textAlign: 'center'
}

//Propt Types
Post.propTypes = {
    category: PropTypes.object.isRequired,
    deletePost: PropTypes.func.isRequired,
    addComment: PropTypes.func.isRequired
}

