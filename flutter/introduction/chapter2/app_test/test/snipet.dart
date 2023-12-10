import 'package:flutter_test/flutter_test.dart';

void main() {
  test('.parse() fails on invalid input', () {
    expect(() => int.parse('X'), throwsFormatException);
  });
}
