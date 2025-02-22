import 'package:flutter/cupertino.dart';
import 'package:flutter/src/material/theme_data.dart';
import 'package:logger/logger.dart';

class LoggerWidget extends StatelessWidget{

  final Widget child;

  final Logger log;

  const LoggerWidget({
    required this.child,
    required this.log,
    super.key, required ThemeData theme});

  @override
  Widget build(BuildContext context) => child;

  static Logger? of(BuildContext context) {
    final LoggerWidget? widget = context.findAncestorWidgetOfExactType<LoggerWidget>();
    return widget?.log;
  }
}