//Christopher Masferrer
//011894127
//CECS 424 - 01 Spring 2020

#include<stdlib.h>
#include<stdio.h>

// Merges two subarrays of arr[].
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]
void merge(int arr[], int l, int m, int r)
{
    //create temporary index values for the arrays
    int i, j, k;
    //store the size of the left and right sides
    int n1 = m - l + 1;
    int n2 =  r - m;

    //create temporary arrays
    int L[n1], R[n2];

    //store values from the left and right sides to the temporary arrays
    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1+ j];

    //initialize the index values
    i = 0; // Left index
    j = 0; // Right index
    k = l; // Merged index
    //combine the values of the three arrays
    while (i < n1 && j < n2)
    {
        //add values of either side if their next value is the smallest
        if (L[i] <= R[j])
        {
            arr[k] = L[i];
            i++;
        }
        else
        {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    //Copy the remaining elements of the left side if there are any
    while (i < n1)
    {
        arr[k] = L[i];
        i++;
        k++;
    }

    //Copy the remaining elements of the left side if there are any
    while (j < n2)
    {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void mergesort(int arr[], int l, int r)
{
    //start if left and right side index are not the same
    if (l < r)
    {
        //find the center index of the array
        int m = l+(r-l)/2;

        //sort the first and second half of the array
        mergesort(arr, l, m);
        mergesort(arr, m+1, r);

        //combine the results together
        merge(arr, l, m, r);
    }
}

void msort(int *a, int n)
{
    //initialize left value
    int left = 0;
    //initialize right value
    int right = n;
    //start merge sort
    mergesort(a, left, right);
}

int main()
{
    //initialize starting array and find the size of the array
    int array[] = {4, 65, 2, -31, 0, 99, 2, 83, 782, 1};
    int n = sizeof(array)/sizeof(array[0]);
    
    //store the value of the array in malloc array
    int *a = (int*)malloc(n * sizeof(int));
    for(int i = 0; i < n; i++)
    {
        a[i] = array[i];
    }

    //sort the array
    msort(a, n - 1);

    //print the results
    printf("Sorted array is \n");
    for (int i = 0; i < n; i++)
        printf("%d ", a[i]);
    return 0;
}
