#include <stdio.h>
#include <stdlib.h>

typedef long long ll;

typedef struct
{
    ll length;
    ll beauty;
} Song;

int compareBeauty(const void *a, const void *b)
{
    Song *x = (Song *)a;
    Song *y = (Song *)b;

    if (x->beauty < y->beauty)
        return 1;

    if (x->beauty > y->beauty)
        return -1;

    return 0;
}

void insertMaxHeap(ll heap[], int *size, ll value)
{
    int i = *size;
    heap[i] = value;
    (*size)++;

    while (i > 0)
    {
        int parent = (i - 1) / 2;

        if (heap[parent] >= heap[i])
            break;

        ll temp = heap[parent];
        heap[parent] = heap[i];
        heap[i] = temp;

        i = parent;
    }
}

ll removeMaxHeap(ll heap[], int *size)
{
    ll maximum = heap[0];

    (*size)--;

    if (*size > 0)
    {
        heap[0] = heap[*size];

        int i = 0;

        while (1)
        {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < *size &&
                heap[left] > heap[largest])
            {
                largest = left;
            }

            if (right < *size &&
                heap[right] > heap[largest])
            {
                largest = right;
            }

            if (largest == i)
                break;

            ll temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            i = largest;
        }
    }

    return maximum;
}

int main()
{
    int n, k;

    scanf("%d", &n);

    Song *songs = malloc(n * sizeof(Song));

    for (int i = 0; i < n; i++)
    {
        scanf("%lld", &songs[i].length);
    }

    for (int i = 0; i < n; i++)
    {
        scanf("%lld", &songs[i].beauty);
    }

    scanf("%d", &k);
    qsort(songs, n, sizeof(Song), compareBeauty);

    ll *heap = malloc((k + 1) * sizeof(ll));

    int heapSize = 0;
    ll sum = 0;
    ll answer = 0;

    for (int i = 0; i < n; i++)
    {
        insertMaxHeap(heap, &heapSize, songs[i].length);
        sum += songs[i].length;

        if (heapSize > k)
        {
            ll removed = removeMaxHeap(heap, &heapSize);
            sum -= removed;
        }

        ll pleasure = sum * songs[i].beauty;

        if (pleasure > answer)
            answer = pleasure;
    }

    printf("%lld\n", answer);

    free(heap);
    free(songs);

    return 0;
}
