import React, { Component } from 'react'

export default class UpdateCategoryTitle extends Component {
    state = {
        title: "",
    }
    
    
        onSubmit = (event) => {
            event.preventDefault()
            this.props.updateCategory(this.props.categoryId, this.state)
            this.setState({ title: '' })
        }
    
        onChange = (event) => this.setState({ [event.target.name]: event.target.value })
    
      render() {
          return (
            <form onSubmit={this.onSubmit} style={{display: 'flex', width: '100%', maxWidth: '500px' , margin: '0 auto'}}>
              <input type="text" name="title" placeholder="new title ..." value={this.state.title} onChange={this.onChange} style={{flex: '10', padding: '5px'}} />
              <input type="submit" value="Submit" className="btn" style={{flex: '1'}} />
            </form>
          ) 
      }
}
