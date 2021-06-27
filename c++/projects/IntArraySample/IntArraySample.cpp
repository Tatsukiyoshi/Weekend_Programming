// IntArraySample.cpp : このファイルには 'main' 関数が含まれています。プログラム実行の開始と終了がそこで行われます。
//

#include <iostream>

// 単純な構造体でIntArrayを構築
struct IntArray {
    int* elems;         // 配列の要素
    size_t numElems;    // 配列の要素の数
};

// IntArrayのインタフェース関数
// IntArrayのインスタンスを生成、消滅
void IA_init(IntArray* object);
void IA_cleanup(IntArray* object);

// IntArrayの要素の数にアクセス
void IA_setSize(IntArray* object, size_t value);
size_t IA_getSize(IntArray* object);

// IntArrayの各要素にアクセス
void IA_setElem(IntArray* object, size_t index, int value);
int IA_getElem(IntArray* object, size_t index);

void error(char* mes) {
    std::cerr << mes;
}

// IA_init()の定義
void IA_init(IntArray* object) {
    object->numElems = 0;
    object->elems = 0;
}

// IA_setSize()の定義
void IA_setSize(IntArray* object, size_t value) {
    if (object->elems != 0) free(object->elems);
    object->numElems = value;
    object->elems = (int*)malloc(value * sizeof(int));
}

// IA_cleanup()の定義
void IA_cleanup(IntArray* object) {
    IA_setSize(object, 0);
}

// IA_getSize()の定義
size_t IA_getSize(IntArray* object) {
    return object->numElems;
}

// IA_getElem()の定義
int IA_getElem(IntArray* object, size_t index) {
    if (index >= object->numElems) error((char *)"bad index");
    return object->elems[index];
}

// IA_setElem()の定義
void IA_setElem(IntArray* object, size_t index, int value) {
    if (index >= object->numElems) error((char *)"bad index");
    object->elems[index] = value;
}

int main()
{
    // std::cout << "Hello World!\n";

    //IntArray powersOf2 = { 0, 0 };  // 2の累乗を保持
    IntArray powersOf2;
    IA_init(&powersOf2);
    
    //powersOf2.numElems = 8;
    //powersOf2.elems = (int*)malloc(powersOf2.numElems * sizeof(int));
    IA_setSize(&powersOf2, 8);

    //powersOf2.elems[0] = 1;
    IA_setElem(&powersOf2, 0, 1);

    //powersOf2.elems[1] = 2 * powersOf2.elems[0];
    IA_setElem(&powersOf2, 1, 2 * IA_getElem(&powersOf2, 0));

    //powersOf2.elems[2] = 2 * powersOf2.elems[1];
    IA_setElem(&powersOf2, 2, 2 * IA_getElem(&powersOf2, 1));

    //powersOf2.elems[3] = 2 * powersOf2.elems[2];
    IA_setElem(&powersOf2, 3, 2 * IA_getElem(&powersOf2, 2));

    //powersOf2.elems[4] = 2 * powersOf2.elems[3];
    IA_setElem(&powersOf2, 4, 2 * IA_getElem(&powersOf2, 3));

    //powersOf2.elems[5] = 2 * powersOf2.elems[4];
    IA_setElem(&powersOf2, 5, 2 * IA_getElem(&powersOf2, 4));

    //powersOf2.elems[6] = 2 * powersOf2.elems[5];
    IA_setElem(&powersOf2, 6, 2 * IA_getElem(&powersOf2, 5));

    //powersOf2.elems[7] = 2 * powersOf2.elems[6];
    IA_setElem(&powersOf2, 7, 2 * IA_getElem(&powersOf2, 6));

    //free(powersOf2.elems);
    IA_cleanup(&powersOf2);
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
