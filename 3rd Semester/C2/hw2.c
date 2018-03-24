#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct itemStruct
{
    int top;
    int stack_size;
    int queue_size;
    int rear;
    int front;
    int current_size ;
    char* queueArray;
    char* stackArray;
    char* logHistory;
    int logCounter;
};

int isStackFull(struct itemStruct* stack)
{
    return (stack)->top == (stack)->stack_size - 1;
}

int isStackEmpty(struct itemStruct* stack)
{
    return (stack)->top == -1 ;
}

char pop(struct itemStruct* stack)
{
    if (isStackEmpty(stack))
    {
        return '\0';
    }
    return (stack)->stackArray[(stack)->top--];
}

void push(struct itemStruct* stack, char item)
{
    if (isStackFull(stack))
    {
        return;
    }
    (stack)->stackArray[++(stack)->top] = item;
}


int size(struct itemStruct* queue)
{
    return (queue)->current_size;
}


int isQueueEmpty(struct itemStruct* queue)
{
    return !(size(queue));
}

int isQueueFull(struct itemStruct* queue)
{
    return (size(queue)==(queue)->queue_size);
}


void enqueue(struct itemStruct* queue,char item)
{
    if(isQueueFull(queue))
    {
        exit(EXIT_FAILURE);
    }
    (queue)->rear = ((queue)->rear +1 ) % (queue)->queue_size,
    (queue)->queueArray[(queue)->rear] = item;
    (queue)->current_size++;
}

char dequeue(struct itemStruct* queue)
{
    if(isQueueEmpty(queue))
    {
        exit(EXIT_FAILURE);
    }
    char x=(queue)->queueArray[(queue)->front];
    (queue)->front = ((queue)->front +1) % (queue)->queue_size;
    (queue)->current_size--;
    return x;
}



void createClientServer(char *filex,char *filey,char *filez,struct itemStruct ** itemArrayAddress,int * totalItemAddress)
{
    FILE *file1 = fopen(filex,"r");
    FILE *file2 = fopen(filey,"r");
    FILE *file3 = fopen(filez,"w");
    int countCommands;
    if(file2!=NULL){
        fscanf(file2,"%d",&countCommands);
    }
    int queueLen ;
    int stackLen ;
    if(file1!=NULL)
    {
        fscanf(file1,"%d",totalItemAddress);
    }
    *itemArrayAddress = (struct itemStruct*) malloc((*totalItemAddress)*sizeof(struct itemStruct));
    int i;
    for(i=0;i<*totalItemAddress;i++)
    {
        fscanf(file1,"%d %d",&queueLen,&stackLen);
        (*itemArrayAddress)[i]=(struct itemStruct){-1,stackLen,queueLen,-1,0,0,(char*)malloc(sizeof(char)*queueLen),(char*)malloc(sizeof(char)*stackLen),
        (char*)malloc(sizeof(char)*4*countCommands),0};
    }
    int x;
    int serverIndex;
    serverIndex = *totalItemAddress;
    for(x=0;x<countCommands;x++)
    {
        char slotOne;
        char slotTwo;
        char slotThree;
        fscanf(file2,"\n%c %c %c",&slotOne,&slotTwo,&slotThree);
        if(slotOne=='A')
        {
            int slotIntTwo = slotTwo-'0';
            if(slotIntTwo!=serverIndex)
            {
                if(isQueueFull(&((*itemArrayAddress)[slotIntTwo-1])))
                {
                    ((*itemArrayAddress)[slotIntTwo-1]).logHistory[(*itemArrayAddress)[slotIntTwo-1].logCounter++]='1';
                }
                else
                {
                    enqueue(&((*itemArrayAddress)[slotIntTwo-1]),slotThree);
                }
            }
        }
        else if(slotOne=='I')
        {
            int slotIntTwo = slotTwo-'0';
            if(isStackFull(&((*itemArrayAddress)[slotIntTwo-1])))
            {
                if(slotIntTwo!=serverIndex){
                    ((*itemArrayAddress)[slotIntTwo-1]).logHistory[(*itemArrayAddress)[slotIntTwo-1].logCounter++]='2';
                }
                else{
                    ((*itemArrayAddress)[slotIntTwo-1]).logHistory[(*itemArrayAddress)[slotIntTwo-1].logCounter++]='2';
                }

            }
            else
            {
                push(&((*itemArrayAddress)[slotIntTwo-1]),slotThree);
            }
        }
        else if(slotOne=='S')
        {
            int slotIntTwo = slotTwo-'0';
            if(!isStackEmpty(&((*itemArrayAddress)[slotIntTwo-1])))
            {
                char val= pop(&((*itemArrayAddress)[slotIntTwo-1]));
                if(isQueueFull(&((*itemArrayAddress)[serverIndex-1])))
                {
                    ((*itemArrayAddress)[serverIndex-1]).logHistory[(*itemArrayAddress)[serverIndex-1].logCounter++]='1';
                    ((*itemArrayAddress)[slotIntTwo-1]).logHistory[(*itemArrayAddress)[slotIntTwo-1].logCounter++]=val;
                }
                else
                {
                    enqueue(&((*itemArrayAddress)[serverIndex-1]),val);
                    ((*itemArrayAddress)[slotIntTwo-1]).logHistory[(*itemArrayAddress)[slotIntTwo-1].logCounter++]=val;
                }
            }
            else if(!isQueueEmpty(&((*itemArrayAddress)[slotIntTwo-1])))
            {
                char kal= dequeue(&((*itemArrayAddress)[slotIntTwo-1]));
                if(isQueueFull(&((*itemArrayAddress)[serverIndex-1])))
                {
                    ((*itemArrayAddress)[serverIndex-1]).logHistory[(*itemArrayAddress)[serverIndex-1].logCounter++]='1';
                    ((*itemArrayAddress)[slotIntTwo-1]).logHistory[(*itemArrayAddress)[slotIntTwo-1].logCounter++]=kal;
                }
                else
                {

                    enqueue(&((*itemArrayAddress)[serverIndex-1]),kal);
                    ((*itemArrayAddress)[slotIntTwo-1]).logHistory[(*itemArrayAddress)[slotIntTwo-1].logCounter++]=kal;
                }
            }
            else if(isStackEmpty(&((*itemArrayAddress)[slotIntTwo-1])) && isQueueEmpty(&((*itemArrayAddress)[slotIntTwo-1])))
            {
                ((*itemArrayAddress)[slotIntTwo-1]).logHistory[(*itemArrayAddress)[slotIntTwo-1].logCounter++]='3';
            }
        }
        else if(slotOne == 'O')
        {
            if(isStackEmpty(&((*itemArrayAddress)[serverIndex-1])) && isQueueEmpty(&((*itemArrayAddress)[serverIndex-1])))
            {
                ((*itemArrayAddress)[serverIndex-1]).logHistory[(*itemArrayAddress)[serverIndex-1].logCounter++]='3';
            }
            else if(!isStackEmpty(&((*itemArrayAddress)[serverIndex-1])))
            {
                char svalue= pop(&((*itemArrayAddress)[serverIndex-1]));
                ((*itemArrayAddress)[serverIndex-1]).logHistory[(*itemArrayAddress)[serverIndex-1].logCounter++]=svalue;
            }
            else if(!isQueueEmpty(&((*itemArrayAddress)[serverIndex-1]))){
                char qvalue= dequeue(&((*itemArrayAddress)[serverIndex-1]));
                ((*itemArrayAddress)[serverIndex-1]).logHistory[(*itemArrayAddress)[serverIndex-1].logCounter++]=qvalue;
            }
        }
    }

    int h;
    int g;
    for(h=0;h<serverIndex;h++){
        for(g=0;g<(*itemArrayAddress)[h].logCounter;g++){
            printf("%c ",(*itemArrayAddress)[h].logHistory[g]);
            fprintf(file3,"%c ",(*itemArrayAddress)[h].logHistory[g]);
        }
        printf("\n");
        fprintf(file3,"\n");
    }



    fclose(file1);
    fclose(file2);
    fclose(file3);

}


int main(int argc,char *argv[])
{
    int totalItem;
    struct itemStruct* itemArray;
    createClientServer(argv[1],argv[2],argv[3],&itemArray,&totalItem);
    return 0;
}

