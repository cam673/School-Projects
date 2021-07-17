//Christopher Masferrer
//011894127
//CECS 424 - Organization of Programming Languages

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//Create the block structure
struct Block {
  int block_size;            //# of bytes in the data section
  struct Block *next_block;  //pointer to the next block
};
// The data section follows in memory after the above struct.

//Determine the size of the block
const int overhead_size = sizeof(struct Block);

//Determine size of void pointer
const int void_pointer = sizeof(void*);

//Create global pointer to point to first free block in the free list
struct Block *free_head;

//Initialize the free list
void my_initialize_heap(int size)
{
  free_head = malloc(size);
  free_head -> block_size = size - overhead_size;
  free_head -> next_block = 0;
}

// rounding up memory size
int roundUp(int numToRound)
{
    int remainder = numToRound % void_pointer;

    if (remainder == 0)
        return numToRound;

    return numToRound + void_pointer - remainder;
}

//Return the appropriate block
void* my_malloc(int size)
{
  //initialize starting point and create a new block
  struct Block *p = free_head;
  struct Block *newBlock;
  
  //find the required size for the new block
  int reqSize = roundUp(size + overhead_size);

  //search through the free list
  while(p)
  {
    //Case 1 : Block size is bigger than the required size
    if(p -> block_size >= reqSize)
    {
      int excess = p->block_size - reqSize;
      if(excess > overhead_size)
      {
        p -> block_size = excess; 
          
        newBlock = (struct Block*)((char*)(p + 1) + excess);
        newBlock -> block_size = size;
        
        newBlock -> next_block = p -> next_block;
        p -> next_block = newBlock;

        return (newBlock + 1);
      }
      else
      {
        p = p -> next_block;
      }
    }
    //Case 2: Block size is not greater than the required size
    //must move to the next block
    else
    {
      p = p -> next_block;
    }
    
  } 
  //Case 3: Space cannot be allocated for the new block
  return 0;
} 

//Deallocate the value
void my_free(void *data)
{
  struct Block *temp = (struct Block *)data -1;
  temp -> next_block = free_head;
  free_head = temp;
}

//create the 5 test cases
void test1()
{
  //Create a new int and deallocate
  printf("***Test 1***\n");
  printf("Allocating t1\n");
  int *t = my_malloc(sizeof(int));
  printf("Address of t1 = %p\n", t);
  printf("Freeing t1\n");
  my_free(t);

  //Create another int and deallocate
  printf("Allocating t2\n");
  int *t2 = my_malloc(sizeof(int));
  printf("Address of t2 = %p\n", t2);
  printf("Freeing t2\n");
  my_free(t2);
  
}

void test2()
{
  //create two ints and deallocate
  printf("***Test 2***\n");
  printf("Allocating t3, t4\n");
  int *t3 = my_malloc(sizeof(int));
  int *t4 = my_malloc(sizeof(int));
    
  printf("Address of t3 = %p\n", t3);
  printf("Address of t4 = %p\n", t4);
    
  printf("Freeing t3, t4\n");
  my_free(t3);
  my_free(t4);
}

void test3()
{
    //create three ints
    printf("***Test 3***\n");
    printf("Allocating t5, t6, t7\n");
    int *t5 = my_malloc(sizeof(int));
    int *t6 = my_malloc(sizeof(int));
    int *t7 = my_malloc(sizeof(int));
    
    printf("Address of t5 = %p\n", t5);
    printf("Address of t6 = %p\n", t6);
    printf("Address of t7 = %p\n", t7);
    //deallocate the second int
    printf("Freeing t6\n");
    my_free(t6);
    
    //allocate a double and check if the address is the same as the second integer
    printf("Allocating double t8\n");
    double *t8 = my_malloc(sizeof(double));
    printf("Address of t8 = %p\n", t8);
    
    //deallocate all
    my_free(t5);
    my_free(t7);
    my_free(t8);
    
}

void test4()
{
    //create an int and a char
    printf("***Test 4***\n");
    printf("Allocating t9, t10\n");
    char *t9 = my_malloc(sizeof(char));
    int *t10 = my_malloc(sizeof(int));
    
    //check the addresses and see if they have the same spacing
    printf("Address of t9 = %p\n", t9);
    printf("Address of t10 = %p\n", t10);
    
    //deallocate the char and int
    my_free(t9);
    my_free(t10);
}

void test5()
{
    //create an int and an int array
    printf("***Test 5***\n");
    printf("Allocating t11, t12\n");
    int *t11 = my_malloc(100 * sizeof(int));
    int *t12 = my_malloc(sizeof(int));
    
    printf("Address of array t11 = %p\n", t11);
    printf("Address of t12 = %p\n", t12);
    
    //free the int array
    printf("Freeing array t11\n");
    my_free(t11);
    
    //check if the int is in the same spot, then deallocate
    printf("Address of t12 = %p\n", t12);
    my_free(t12);
}

//Test the block allocation
int main(int argc, const char * argv[])
{
  //initialize the heap
  printf("Initializing Heap\n");
  my_initialize_heap(1000);
  
  //Execute all 5 tests
  printf("Start Testing\n");
  test1();
  test2();
  test3();
  test4();
  test5();
  printf("End of Testing\n");
  
  //start the main program
  printf("Start of Main Program\n");
  int n = 0;
  
  //ask user to enter the number of integers they would like to use
  printf("Enter the number of integers you would like to allocate space for: \n");
  while(n <= 0)
  {
      scanf("%d", &n);
      if(n <= 0)
      {
          printf("\nERROR: The number entered must be greater than 0.\n");
          printf("Enter the number of integers you would like to allocate space for: \n");
      }
  }
  
  //allocate space for the integers
  int *result = my_malloc(n * sizeof(int));
  
  //read n integers from the user into the array
  printf("Enter the numbers you would like to use (one at a time): \n");
  int i = 0;
  while(i < n)
  {
      scanf("%d", &result[i]);
      i++;
  }

  //calculate and print the standard deviation  
  float sum = 0.0;
  float mean; 
  float SD = 0.0;
  i = 0;
  for (i = 0; i < n; ++i) 
  {
    sum += result[i];
  }
  mean = sum / n;
  for (i = 0; i < n; ++i)
    SD += pow(result[i] - mean, 2);
  float sdResult = sqrt(SD / n);
  
  printf("The Standard Deviation of the values entered is %.6f", sdResult);
  my_free(result);
  
  return 0;
}