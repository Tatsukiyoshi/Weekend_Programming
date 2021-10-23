#pragma once
using namespace std;

class IntArray
{
public:
	IntArray();
	~IntArray();

private:
	int* elems;
	size_t numElems;
};

