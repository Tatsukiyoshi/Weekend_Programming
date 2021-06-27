/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import * as React from 'react';
import { Text, TextInput, Button, View, StyleSheet } from 'react-native';
// import { Constants } from 'expo';

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { message: 'type number',
      input: '0', data: ''};
  }

  doType = (input) => this.setState({input});

  doAction = () => {
    let arr = this.state.input.split('\n');
    var total = 0;
    for(var i = 0; i < arr.length; i++) {
      total += arr[i] * 1;
    }
    this.setState({ message: 'total: ' + total});
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.title}>Calc</Text>
        <Text style={styles.msg}>
          {this.state.message}</Text>
        <TextInput style={styles.input} multiline={true}
          onChangeText={this.doType}
          value={this.state.input} />
        <Button title="Touch me!"
          onPress={this.doAction} />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    // paddingTop: Constants.statusBarHeight,
    backgroundColor: '#ecf0f1',
    padding: 8,
  },
  title: {
    margin: 20,
    fontSize: 24,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  input: {
    margin: 20,
    marginTop: 0,
    fontSize: 24,
//  fontWeight: 'plain',
    fontWeight: 'normal',
    textAlign: 'left',
    borderBottomColor: 'gray',
    borderBottomWidth: 2,
  },
  msg: {
    margin: 20,
    fontSize: 20,
    fontWeight: 'bold',
    textAlign: 'center',
  },
});
