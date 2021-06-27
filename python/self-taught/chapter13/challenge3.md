# 図形で継承関係を学ぶ

```PlantUML
@startuml

class Shape {
    what_am_i()
}

class Rectangle {
    width
    len
    calculate_perimeter()
}

class Square {
    side
    calculate_perimeter()
    change_size()
}

Rectangle --> Shape
Square --> Shape

@enduml
```
