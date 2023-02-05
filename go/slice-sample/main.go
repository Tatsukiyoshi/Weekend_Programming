package main

import (
	"fmt"
	"unsafe"
)

func main() {
	var slice1 []int
	fmt.Printf("%v", slice1)

	var slice2 = []int{}
	fmt.Printf("%v", slice2)

	slice3 := []int{1, 2, 3, 4, 5}
	fmt.Printf("%v", slice3)

	fmt.Println(unsafe.StringData("Hello"))
	fmt.Println(unsafe.SliceData(slice3))
}
