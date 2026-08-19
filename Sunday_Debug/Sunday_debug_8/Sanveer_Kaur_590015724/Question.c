#include <stdio.h>

#define SIZE 100

int heap[SIZE], heapSize = 0;

void swap(int *a, int *b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

void insert(int value)
{
    heap[heapSize] = value;
    int cur = heapSize++;

    while (cur > 0)
    {
        // BUG 1: Parent index was wrong
        int par = (cur - 1) / 2;

        // BUG 2: Comparison was for Min Heap instead of Max Heap
        if (heap[cur] > heap[par])
        {
            swap(&heap[cur], &heap[par]);
            cur = par;
        }
        else
        {
            break;
        }
    }
}

void heapifyDown(int idx)
{
    int largest = idx;

    int l = 2 * idx + 1;
    int r = 2 * idx + 2;

    // BUG 3: Comparisons were reversed
    if (l < heapSize && heap[l] > heap[largest])
        largest = l;

    if (r < heapSize && heap[r] > heap[largest])
        largest = r;

    if (largest != idx)
    {
        swap(&heap[idx], &heap[largest]);
        heapifyDown(largest);
    }
}

int extractMax()
{
    if (heapSize == 0)
        return -1;

    int maxVal = heap[0];

    // BUG 4: Uninitialized variable removed
    heap[0] = heap[--heapSize];
    heapifyDown(0);

    return maxVal;
}

void display()
{
    printf("Heap: ");

    for (int i = 0; i < heapSize; i++)
        printf("%d ", heap[i]);

    printf("\n");
}

int main()
{
    insert(40);
    insert(25);
    insert(50);
    insert(10);
    insert(60);

    display();

    printf("Extracted: %d\n", extractMax());

    display();

    return 0;
}