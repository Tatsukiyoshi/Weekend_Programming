#include "IntArray.h"
#include <iostream>

IntArray::IntArray() {
	numElems = 0;
	elems = 0;

	cout << "in IntArray default constructor, object address"
		<< this << '\n';
}
