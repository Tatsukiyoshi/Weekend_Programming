main(){
    var appends = ["append1","append2"];
    var children = [
        Widget("sample1"),
        Widget("sample2"),
        for(var name in appends) Widget(name), // （1）
        Widget("sample3")
    ];
    print(children);
    // [sample1, sample2, append1, append2, sample3]
}
