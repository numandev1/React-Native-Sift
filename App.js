/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';

import Sift from './main/SiftModuleNativeModule';

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
  android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
export default class App extends Component<Props> {
  state={
    name:""
  }
  

  componentDidMount(){
    // console.log(Sift,"Sift",Sift.haseebTest());
    Sift.haseebTest().then((value)=>{
      console.log(value,"valuevaluevalue");
      this.setState({name:value});
    })

    Sift.set(id)
  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>{Sift.EXAMPLE_CONSTANT}</Text>
        <Text style={styles.welcome}>{this.state.name+"nomi"}</Text>
        
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
