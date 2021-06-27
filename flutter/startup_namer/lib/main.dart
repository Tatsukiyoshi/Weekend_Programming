import 'package:flutter/material.dart';
// Step 2: Use an external package
import 'package:english_words/english_words.dart';

void main() => runApp(MyApp());

// Step 1: Create the starter Flutter app
class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    // Step 2: Use an external package
    // Step 3: Add a Stateful widget
    //final wordPair = WordPair.random();
    return MaterialApp(
      // Step 4: Create an infinite scrolling ListView
      //title: 'Welcome to Flutter',
      title: 'Startup Name Generator',
      //home: Scaffold(
      //  appBar: AppBar(
      //    title: Text('Welcome to Flutter'),
      //  ),
      //  body: Center(
//        Step 2: Use an external package
//        child: Text('Hello World'),
//        Step 3: Add a Stateful widget
//        child: Text(wordPair.asPascalCase),
      //    child: RandomWords(),
      //  ),
      //),
      home: RandomWords(),
    );
  }
}

// Step 3: Add a Stateful widget
class RandomWordsState extends State<RandomWords> {
  // Step 4: Create an infinite scrolling ListView
  final _suggestions = <WordPair>[];
  final _biggerFont = const TextStyle(fontSize: 18.0);

  @override
  Widget build(BuildContext context) {
    // Step 4: Create an infinite scrolling ListView
    //final wordPair = WordPair.random();
    //return Text(wordPair.asPascalCase);
    return Scaffold(
      appBar: AppBar(
        title: Text('Startup Name Generator'),
      ),
      body: _buildSuggestions(),
    );
  }

  Widget _buildSuggestions() {
    return ListView.builder(
      padding: const EdgeInsets.all(16.0),
      itemBuilder: /*1*/ (context, i) {
        if (i.isOdd) return Divider(); /*2*/

        final index = i ~/ 2; /*3*/
        if (index >= _suggestions.length) {
          _suggestions.addAll(generateWordPairs().take(10));  /*4*/
        }
        return _buildRow(_suggestions[index]);
      }
    );
  }

  Widget _buildRow(WordPair pair) {
    return ListTile(
      title: Text(
        pair.asPascalCase,
        style: _biggerFont,
      ),
    );
  }
}

class RandomWords extends StatefulWidget {
  @override
  RandomWordsState createState() => RandomWordsState();
}
