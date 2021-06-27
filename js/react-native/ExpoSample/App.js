/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import * as React from 'react';
import { Text, Button, View, StyleSheet } from 'react-native';
// import { Constants } from 'expo';
// https://bagelee.com/programming/react-native/react-native-layout/
// Expoパッケージを利用せず、デバイスのサイズをもとに算出するように修正

// デバイスのサイズを取得する
// var {height, width} = Dimensions.get('window');

export default class App extends React.Component {
  counter = 0;

  constructor(props) {
    super(props);
    this.state = {message: 'touch me...'};
  }
  // タッチ時の処理
  doAction = ()=> {
    this.setState({message: 'count: ' + ++this.counter});
  }

  render(){
    return (
      <View style={styles.container}>
        <Text style={styles.title}>Expo Sample</Text>
        <Text style={styles.paragraph}>{this.state.message}</Text>
        <Button title="Touch me!" onPress={this.doAction} />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    // paddingTop: Constants.statusBarHeight,
    // height: height - 100,
    backgroundColor: '#ecf0f1',
    padding: 8,
  },
  title: {
    margin: 20,
    fontSize: 24,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  paragraph: {
    margin: 24,
    fontSize: 18,
    fontWeight: 'bold',
    textAlign: 'center',
  },
});
