import sys
myfile=open(sys.argv[1],"r")

read=myfile.readlines()

bulletList=[]
for elements in read:
    bulletList.append(elements.rstrip('\n').split(" "))
for numbs in bulletList:
    numbs[0]=int(numbs[0])
    numbs[1]=int(numbs[1])
    numbs[2]=float(numbs[2])

m=initialvalues=[]
fuelcosts=[]
taxes=[]
for item in bulletList:
    initialvalues.append(item[0:len(bulletList)][0])
    fuelcosts.append(item[0:len(bulletList)][1])
    taxes.append(item[0:len(bulletList)][2])

for x in range(len(initialvalues)):
    initialvalues[x]=int(initialvalues[x])
for y in range(len(fuelcosts)):
    fuelcosts[y]=int(fuelcosts[y])
for z in range(len(taxes)):
    taxes[z]=float(taxes[z])

def calculateTotalCost(list):
    ResultList=[]
    j=taxesin10years=[]
    k=fuelcostsin10years=[]
    mj=[]#m=initialvalues list j=taxesin10years,so mj means multiplied list#
    for item1 in fuelcosts:
        fuelcostsin10years.append(item1*10)
    for item2 in taxes:
        taxesin10years.append(item2*10)
    for item3 in range(0,len(m)):
        mj.append(m[item3]*j[item3])
    for item4 in range(0,len(mj)):
        ResultList.append(mj[item4]+k[item4]+m[item4])
    return (ResultList)

def displayCosts(list):
    displayList=calculateTotalCost(list)
    print("The total cost of each house :")
    for i in range(1,len(displayList)+1):
        print(str(i)+". house's total cost is",displayList[i-1])

def selectBestBuy(list):
    BestBuyList=calculateTotalCost(list)
    minimum = BestBuyList[0]
    for element in BestBuyList[1:]:
        if element < minimum:
            minimum = element
    print("You should select",str(BestBuyList.index(minimum)+1)+".house whose total cost is",minimum)

displayCosts(bulletList)
selectBestBuy(bulletList)

myfile.close()
