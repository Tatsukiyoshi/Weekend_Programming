class Response{
  final bool _ok;
  final int _code;
  final String _message;
  final dynamic _body;

  Response(this._ok, this._code) : _message = '', _body = Null;
  Response.error(this._code,this._message) : _ok = false, _body = Null;
  Response.ok(this._code,this._message,this._body): _ok = true;

  String get message => _message;
  int get code => _code;
  bool get ok => _ok;

  @override
  String toString() {
    return 'Response{_ok: $_ok, _code: $_code, _message: $_message}';
  }
}