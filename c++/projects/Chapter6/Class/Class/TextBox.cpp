#include "TextBox.h"

TextBox::TextBox()
{
	frameThickness = 0;
	text = 0;
	std::cout << "in default constructor for: TextBox\n";
}

TextBox::~TextBox()
{
	std::cout << "in destructor for: TextBox\n";
	if (text != 0) free(text);
}

void TextBox::setText(char* pText)
{
	text = (char *)malloc(sizeof(&pText));
	if (text != 0) {
		text = pText;
	}
}
