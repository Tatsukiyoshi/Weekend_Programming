class DateItem{

  int day;
  String week;
  String text;
  bool today = false;

  DateItem(this.day, this.week, this.text, this.today);

  factory DateItem.fromJson(Map<String,dynamic> json){
    return DateItem(
        json['day'] as int,
        json['week'] as String ,
        json['text'] ?? json['text'],
        json['today'] as bool
    );
  }
}