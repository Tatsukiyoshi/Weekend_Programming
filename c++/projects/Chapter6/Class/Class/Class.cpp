// Class.cpp : このファイルには 'main' 関数が含まれています。プログラム実行の開始と終了がそこで行われます。

#include <iostream>
#include "TextBox.h"

int main()
{
	TextBox tbox;

	char text[5] = "text";
	tbox.setText((char *)&text);
	std::cout << "--->main() complete<---\n";
}
