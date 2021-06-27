#include <stdio.h>

int loop(int n){
    int i;
    for(i = 0; i < n; i+=1)
        printf("%d\n", i);
    return i;
}
