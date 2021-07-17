//Christopher Masferrer
//011894127
//CECS 424 - Organization of Programming Languages

#include <stdio.h>
#include <stdlib.h>

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
  struct Block *p = free_head;
  struct Block *newBlock;
  struct Block *nextBlock;

  nextBlock = p -> next_block;
  int reqSize = roundUp(size + overhead_size);

  while(p)
  {
    if(p -> block_size >= reqSize)
    {
      int excess = p->block_size - reqSize;
      if(excess > overhead_size)
      {
        newBlock = (struct Block*)((char*)(p + 1) + reqSize);
        newBlock -> block_size = size;
        newBlock -> next_block = nextBlock;

        (p -> next_block) = newBlock;

        return (void*)(newBlock + 1);
      }
      else
      {
        p = p -> next_block;
        return(void*)(p + 1);
      }
    }
    else if (p -> block_size < reqSize)
    {
      p = p -> next_block;
    }
    else
    {
      return 0;
    }
  }
}

//Deallocate the value
void my_free(void *data)
{
  struct Block *temp = ((struct Block *)data -1);
  temp -> next_block = free_head;
  free_head = temp;
}

void test1()
{
  printf("Initializing Heap\n");
  my_initialize_heap(100);
  printf("***Test 1***\n");
  printf("Allocating t1\n");
  int *t = my_malloc(sizeof(int));
  printf("%p\n", t);
  printf("Freeing t1\n");
  my_free(t);

  printf("Allocating t2\n");
  int *t2 = my_malloc(sizeof(int));
  printf("%p\n", t2);
  printf("Freeing t2\n");
  my_free(t2);

}

void test2()
{
  printf("Initializing Heap\n");
  my_initialize_heap(100);
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
    printf("Initializing Heap\n");
    my_initialize_heap(100);
    printf("***Test 3***\n");
    printf("Allocating t5, t6, t7\n");
    int *t5 = my_malloc(sizeof(int));
    int *t6 = my_malloc(sizeof(int));
    int *t7 = my_malloc(sizeof(int));

    printf("Address of t5 = %p\n", t5);
    printf("Address of t6 = %p\n", t6);
    printf("Address of t7 = %p\n", t7);

    printf("Freeing t6\n");
    my_free(t6);

    printf("Allocating double t8\n");
    double *t8 = my_malloc(sizeof(double));
    printf("Address of t8 = %p\n", t8);

    my_free(t5);
    my_free(t7);
    my_free(t8);

}

//Test the block allocation
int main(int argc, const char * argv[])
{
  //printf("Initializing Heap\n");
  //my_initialize_heap(100);

  printf("Enter Main\n");
  test1();
  test2();
  test3();
  printf("End of Testing\n");
  return 0;
}
