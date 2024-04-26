class Response{
  final bool _ok;
  final int _code;
  final String _message;

  Response(this._ok, this._code) : _message = '';
  Response.error(this._code,this._message) : _ok = false;

  String get message => _message;
  int get code => _code;
  bool get ok => _ok;

  @override
  String toString() {
    return 'Response{_ok: $_ok, _code: $_code, _message: $_message}';
  }
}