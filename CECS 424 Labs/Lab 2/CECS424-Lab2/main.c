#include <stdio.h>
#include <stdlib.h>

//1. Create Block struct
struct Block
{
    int block_size;
    struct Block *next_block;
};

//2. Store Block size
const int overhead_size = sizeof(struct Block);

//3. Size of void*
const int void_pointer = sizeof(void*);

//4. Global Block pointer
struct Block *free_head;

//5. Create Initialize Heap
void my_initialize_heap(int size)
{
    free_head = malloc(size);
    free_head -> block_size = size * 2;
    //free_head -> next_block = ???;
}

//Shown during lab, not sure where this goes
//free_head = (struct Block*)((char*)size + overhead_size);

//6. Create my_alloc function
//void* my_alloc(int size)
//{


//}

//7. Create my_free function
void my_free(void *data)
{
    
}

int main(int argc, const char * argv[])
{
    //testing void pointer value
    printf("The value of the void pointer is %d.\n", void_pointer);
    return 0;
}
