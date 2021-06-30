// IntArraySample.cpp : このファイルには 'main' 関数が含まれています。プログラム実行の開始と終了がそこで行われます。
//

#include <iostream>

// メンバ関数を持つクラスと同じオブジェクトを定義
class IntArray {
    // IntArrayのインタフェース関数
public:
    IntArray();     // コンストラクタ
    ~IntArray();    // デストラクタ

    // IntArrayの要素の数にアクセス
    void setSize(size_t value);
    size_t getSize();

    // IntArrayの各要素にアクセス
    void setElem(size_t index, int value);
    int getElem(size_t index);

private:
    int* elems;         // 配列の要素
    size_t numElems;    // 配列の要素の数
};

void error(char* mes) {
    std::cerr << mes;
}

// コンストラクタの定義
IntArray::IntArray() {
    numElems = 0;
    elems = 0;
}

// setSize()の定義
void IntArray::setSize(size_t value) {
    if (this->elems != 0) free(this->elems);
    this->numElems = value;
    this->elems = (int*)malloc(value * sizeof(int));
}

// デストラクタの定義
IntArray::~IntArray() {
    this->setSize(0);
}

// getSize()の定義
size_t IntArray::getSize() {
    return this->numElems;
}

// getElem()の定義
int IntArray::getElem(size_t index) {
    if (index >= this->numElems) error((char *)"bad index");
    return this->elems[index];
}

// setElem()の定義
void IntArray::setElem(size_t index, int value) {
    if (index >= this->numElems) error((char *)"bad index");
    this->elems[index] = value;
}

int main()
{
    // std::cout << "Hello World!\n";

    //IntArray powersOf2 = { 0, 0 };  // 2の累乗を保持
    IntArray powersOf2;
    
    //powersOf2.numElems = 8;
    //powersOf2.elems = (int*)malloc(powersOf2.numElems * sizeof(int));
    powersOf2.setSize(8);

    //powersOf2.elems[0] = 1;
    powersOf2.setElem(0, 1);

    //powersOf2.elems[1] = 2 * powersOf2.elems[0];
    powersOf2.setElem(1, 2 * powersOf2.getElem(0));

    //powersOf2.elems[2] = 2 * powersOf2.elems[1];
    powersOf2.setElem(2, 2 * powersOf2.getElem(1));

    //powersOf2.elems[3] = 2 * powersOf2.elems[2];
    powersOf2.setElem(3, 2 * powersOf2.getElem(2));

    //powersOf2.elems[4] = 2 * powersOf2.elems[3];
    powersOf2.setElem(4, 2 * powersOf2.getElem(3)); 

    //powersOf2.elems[5] = 2 * powersOf2.elems[4];
    powersOf2.setElem(5, 2 * powersOf2.getElem(4));

    //powersOf2.elems[6] = 2 * powersOf2.elems[5];
    powersOf2.setElem(6, 2 * powersOf2.getElem(5));

    //powersOf2.elems[7] = 2 * powersOf2.elems[6];
    powersOf2.setElem(7, 2 * powersOf2.getElem(6));

    //free(powersOf2.elems);
}

// プログラムの実行: Ctrl + F5 または [デバッグ] > [デバッグなしで開始] メニュー
// プログラムのデバッグ: F5 または [デバッグ] > [デバッグの開始] メニュー

// 作業を開始するためのヒント: 
//    1. ソリューション エクスプローラー ウィンドウを使用してファイルを追加/管理します 
//   2. チーム エクスプローラー ウィンドウを使用してソース管理に接続します
//   3. 出力ウィンドウを使用して、ビルド出力とその他のメッセージを表示します
//   4. エラー一覧ウィンドウを使用してエラーを表示します
//   5. [プロジェクト] > [新しい項目の追加] と移動して新しいコード ファイルを作成するか、[プロジェクト] > [既存の項目の追加] と移動して既存のコード ファイルをプロジェクトに追加します
//   6. 後ほどこのプロジェクトを再び開く場合、[ファイル] > [開く] > [プロジェクト] と移動して .sln ファイルを選択します
