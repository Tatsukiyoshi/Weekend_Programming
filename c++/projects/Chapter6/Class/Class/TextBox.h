#pragma once
#include "Rect.h"
#include "Color.h"
class TextBox :
    public Rect
{
public:
	TextBox();
	~TextBox();
	void setText(char* pText);

private:
	Color textColor;
	int frameThickness;
	char* text;
};
