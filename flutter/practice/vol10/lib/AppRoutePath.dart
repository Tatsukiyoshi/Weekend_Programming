//
// パス情報
//
class AppRoutePath {
  final String id;

  AppRoutePath.list() : id = null;

  AppRoutePath.item(this.id);

  bool get isListPage => id == null;

  bool get isItemPage => id != null;
}