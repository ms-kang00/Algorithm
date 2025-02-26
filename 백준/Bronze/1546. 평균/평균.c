#include <stdio.h>

int main()
{
    int N;
    int max = 0;
    double avg = 0;

    scanf("%d", &N);

    int score[1000];

    for (int i = 0; i < N; i++) {
        scanf("%d", &score[i]);
        if (max < score[i]) {
            max = score[i];
        }
    }

    for (int i = 0; i < N; i++) {
        avg += (double)score[i] / max * 100;
    }

    printf("%lf\n", avg / N);

    return 0;
}