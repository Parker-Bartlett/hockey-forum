import React, { Component } from 'react'
import PropTypes from 'prop-types'
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
      <div style={formWrapper}>
        <form onSubmit={this.onSubmit} style={formStyle}>
          <input type="text" name="title" placeholder="new title ..." value={this.state.title} onChange={this.onChange} style={{ flex: '10', padding: '5px' }} />
          <input type="submit" value="Submit" className="btn" style={buttonStyle} />
        </form>
      </div>
    )
  }
}

const formWrapper = {
  backgroundColor: '#555',
  paddingBottom: '10px'
}

const formStyle = {
  display: 'flex',
  width: '100%',
  maxWidth: '500px',
  margin: '0 auto'
}

const buttonStyle = {
  flex: '1', padding: '2px',
  borderRadius: '5px',
  backgroundColor: 'forestGreen',
  color: 'white'
}

// PropTypes
UpdateCategoryTitle.propTypes = {
  categoryId: PropTypes.object.isRequired,
  updateCategory: PropTypes.func.isRequired
}