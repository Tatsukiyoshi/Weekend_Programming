#pragma once
#include <iostream>
class Rect
{
public:
	Rect() {
		left = top = width = height = 0;
		std::cout << "in default constructor for: Rect\n";
	}

	~Rect() {
		std::cout << "in destructor for: Rect\n";
	}

private:
	int left, top;    	// ����p
	int width, height;	// �T�C�Y
};
