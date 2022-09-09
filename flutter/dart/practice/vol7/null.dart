main(){
    var root = Node.root();
    root.appendChild("child1");
    // どのインスタンがnullでもエラーにならない記述
    var target1 = root?.firstChild?.next?.firstChild; // （1）
    // （省略）
}
