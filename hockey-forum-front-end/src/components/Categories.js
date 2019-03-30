import React, { Component } from 'react'
import PropTypes from 'prop-types'
import Category from './Category'

export default class Categories extends Component {
  render() {
    return this.props.categories.map((category) => (
        <Category category={ category }/>
    ))
  }
}

// Proptypes
Categories.propTypes = {
    categories: PropTypes.array.isRequired
}


