import React, { Component } from 'react'

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
        <form onSubmit={this.onSubmit} style={{display: 'flex'}}>
          <input type="text" name="commentContent" placeholder="comment ..." value={this.state.commentContent} onChange={this.onChange} style={{flex: '10', padding: '5px'}} />
          <input type="submit" value="Submit" className="btn" style={{flex: '1'}} />
        </form>
      ) 
  }
}

export default AddComment