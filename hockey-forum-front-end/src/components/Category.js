import React, { Component } from 'react'
import PropTypes from 'prop-types'

export default class Category extends Component {
  render() {
    return (
      <div>
        <p>{this.props.category.title}</p>
      </div>
    )
  }
}

// PropTypes
Category.propTypes = {
    category: PropTypes.object.isRequired
}
