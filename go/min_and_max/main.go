package main

import (
	"fmt"
)

func main() {
	var array1 = [5]int{1, 2, 3, 4, 5}
	fmt.Printf("max %v\n", max(1, 2, 3, 4, 5))
	fmt.Printf("min %v\n", min(1, 2, 3, 4, 5))
	fmt.Printf("%v\n", array1)
}
