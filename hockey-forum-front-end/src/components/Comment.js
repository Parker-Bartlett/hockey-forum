import React, { Component } from 'react'
import PropTypes from 'prop-types'


export default class Comment extends Component {
  render() {
    return this.props.post.comment.map((comment) => (
        <div>
            <p>{comment.commentContent}</p>
        </div>
    ))
  }
  }

//Prop Types
Comment.propTypes = {
    post: PropTypes.object.isRequired,
}
