package main

import (
	"fmt"
	"unsafe"
)

func main() {
	fmt.Println(unsafe.StringData("Hello"))

	var slice1 []int
	fmt.Printf("%v", slice1)

	var slice2 = []int{}
	fmt.Printf("%v", slice2)

	slice3 := []int{1, 2, 3, 4, 5}
	fmt.Printf("%v", slice3)
	fmt.Println(unsafe.SliceData(slice3))

	// V1.21: New function clear
	clear(slice3)
	fmt.Printf("%v", slice3)
}
