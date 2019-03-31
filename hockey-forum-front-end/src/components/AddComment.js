import React, { Component } from 'react'
import PropTypes from 'prop-types'

export class AddComment extends Component {

state = {
    commentContent: "",
}


    onSubmit = (event) => {
        event.preventDefault()
        this.props.addComment(this.props.post.id, this.state)
        this.setState({ commentContent: '' })
    }

    onChange = (event) => this.setState({ [event.target.name]: event.target.value })

  render() {
      return (
        <form onSubmit={this.onSubmit} style={onSubmit}>
          <input type="text" name="commentContent" placeholder="comment ..." value={this.state.commentContent} onChange={this.onChange} style={commentInput} />
          <input type="submit" value="Submit" className="btn" style={commentSubmit} />
        </form>
      ) 
  }
}

const onSubmit = {
  display: 'flex', 
  width: '100%', 
  maxWidth: '500px', 
  margin: '0 auto'
}

const commentInput = {
  flex: '10',
  padding: '5px'
}

const commentSubmit = {
  flex: '1',
  padding: '2px', 
  borderRadius: '5px', 
  backgroundColor: 'forestGreen',
  color: 'white'
}

// Prop Types
AddComment.propTypes = {
  post: PropTypes.object.isRequired,
  addComment: PropTypes.func.isRequired
}

export default AddComment