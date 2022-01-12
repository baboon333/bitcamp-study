#include <stdio.h>

float eom_plusf(float a, float b) {
    return a + b;
}

int eom_plusi(int a, int b) {
    return a + b;
}

int main(void) {
    printf("Hello!\n");
    
    int r = eom_plusf(100, 200);
    printf("r = %d\n", r);
    
    float r2 = eom_plusi(100.5f, 200.2f);
    printf("r2 = %f\n", r2);
} 
// 아톰으로 봐봐! C언어임!
// C에서는 파라미러가 다르다고 해도 같은 이름을 가진 메서드를 가질 수 없다!






