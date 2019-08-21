//  Created by react-native-create-bridge

import React, { Component } from 'react'
import { requireNativeComponent } from 'react-native'

const SiftModule = requireNativeComponent('SiftModule', SiftModuleView)

export default class SiftModuleView extends Component {
  render () {
    return <SiftModule {...this.props} />
  }
}

SiftModuleView.propTypes = {
  exampleProp: React.PropTypes.any
}
