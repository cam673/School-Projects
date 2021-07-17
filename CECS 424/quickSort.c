//Christopher Masferrer
//011894127
//CECS 424 - 01 Spring 2020

#include <stdio.h>
#include <stdlib.h>

//used to swap two elements
void swap(int* a, int* b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

//partition function finds the pivot and sorts the list
int partition(int a[], int begin, int end)
{
  //use the end as the pivot and initialize the starting index
  int pivot = a[end];
  int i = (begin - 1);

  //sort through the array and find values smaller than the starting element
  for(int j = begin; j <= end - 1; j++)
  {
    //swap values only if the current element is lower than the pivot value
    if(a[j] < pivot)
    {
      i++;
      //smaller values will be located to the left side of the pivot
      swap(&a[i], &a[j]);
    }
  }
  //move the pivot to the center position
  swap(&a[i + 1], &a[end]);
  //return the value of the pivot
  return (i + 1);
}

//quicksort function starts at the first index position
void quicksort(int a[], int begin, int end)
{
  //only enter if there is more than one element to sort
  if(begin < end)
  {
    //find the partitioning index and sort the left and right sides of the pivot
    int p = partition(a, begin, end);
    quicksort(a, begin, p - 1);
    quicksort(a, p + 1, end);
  }
}

//initializes quick sort function
void qsort2(int *a, int n)
{
    //initialize starting position
    int start = 0;
    //end of array
    int end = n-1;
    //start quicksort loop
    quicksort(a, start, end);
}

int main()
{
   //initialize starting array and find the size of the array
   int array [] = {4, 65, 2, -31, 0, 99, 2, 83, 782, 1};
   int n = sizeof(array)/sizeof(array[0]);
   //store the value of the array in malloc array
    int *a = (int*)malloc(n * sizeof(int));
    for(int i = 0; i < n; i++)
    {
        a[i] = array[i];
    }
   //call quick sort function
   qsort2(a, n);
   //print out quick sort results
   printf("Sorted array: ");
   for (int i=0; i < n; i++)
        printf("%d ", a[i]);
   return 0;
}
