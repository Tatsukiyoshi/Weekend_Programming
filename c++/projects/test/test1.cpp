#include <iostream>
#include <vector>
#include <string>

using namespace std;
class Test1 {
    int x;
    int y;
};

class Test2 {
    int a;
    int b;
};

class TestParent {
public:
    CArray<*Test1, *Test2> mTestArray;
};

int main(int argc, char const *argv[])
{
    /* code */
    TestParent testParent = TestParent();
    testParent.mTestArray.removeAll();

    return 0;
}
