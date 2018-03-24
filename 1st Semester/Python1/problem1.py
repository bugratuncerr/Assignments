import sys
myfile=open(sys.argv[1],"r")

readline=myfile.readline()
for ListIntegers in readline:
    ListIntegers=readline.strip('\n').split(';')

numbers=[]
avgdigits=[]
def avgFirstThreeDigit():
    for string in ListIntegers:
        a=string[0:len(ListIntegers)][0:3]
        numbers.append(a)
    for digit in numbers:
        First=digit[0:len(numbers)][0]
        Second=digit[0:len(numbers)][1]
        Third=digit[0:len(numbers)][2]
        avgdigits.append((float(First)+float(Second)+float(Third))/float(3))
    for i in range(int(len(avgdigits)/2)):
        avgdigits[int(i)], avgdigits[-int(i+1)] = avgdigits[-int(i+1)], avgdigits[int(i)]
    return(avgdigits)

output=avgFirstThreeDigit()
print(output)
myfile.close()
