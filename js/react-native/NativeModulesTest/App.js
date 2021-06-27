/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';
import {NativeModules} from 'react-native';

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
  android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
export default class App extends Component<Props> {
  constructor(props:Props) {
    super(props);
    this.state = {osInfo:''};
    // 定義したモジュール名が、NativeModules に存在するようになる。
    var DeviceInformation = NativeModules.DeviceInformation;
　　
    // 定義した関数名で呼び出し。ネイティブ上で callback に渡した引数の値がその順序で引数として渡される。
    DeviceInformation.getOSInfo((os, version) => {
        this.setState({osInfo: `${os} ${version}`});
    });
  }

  render() {
    return (
      <View style={styles.container}>
        <Text>OS:{this.state.osInfo}</Text>
        <Text style={styles.welcome}>Welcome to React Native!</Text>
        <Text style={styles.instructions}>To get started, edit App.js</Text>
        <Text style={styles.instructions}>{instructions}</Text>
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
