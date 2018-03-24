import matplotlib.pyplot as plt
import csv
import numpy as np
import random
import sys
import heapq

state_of_dist=[]
total_vote=[]
data=[]
b=[]
nominees=[]
result=[]
def retrieveData(file,list):
    with open(file,"r") as csvfile:
        reads=csv.reader(csvfile,delimiter=",")
        for row in reads:
            data.append(row)
            state_of_dist.append(row[0])
    al = [item for item in list if item in data[0]]
    q=[]
    for item in al:
       q.append(data[0].index(item))
    for number in q:
        for line in data:
            b.append(line[number])
    for elegant in b:
        try:
            elegant=int(elegant)
            result.append(int(elegant))
        except:
            nominees.append(elegant)
    total_vote.append(sum(result))
    return(result)
retrieveData(sys.argv[1],sys.argv[2].split(","))
with open("retrievedData.txt","w") as txt:
    txt.write(str(result))

apk=[]
sums=[]
name1=[]
name2=[]
def DispBarPlot():
    for nom in nominees:
        apk.append(b[b.index(nom):(len(state_of_dist)+b.index(nom))])
    for element in apk:
        baz=[int(xaz) for xaz in element[1:]]
        sums.append(sum(baz))
    max1,max2=heapq.nlargest(2,sums)
    name_max1=nominees[sums.index(max1)]
    name_max2=nominees[sums.index(max2)]
    new_data=[elts for elts in data[1:]]
    states=[state[0] for state in new_data]
    index_name1=data[0].index(name_max1)
    index_name2=data[0].index(name_max2)
    for number in new_data:
        name2.append(int(number[index_name2]))
        name1.append(int(number[index_name1]))
    ind=np.arange(len(states))
    width=0.35
    plt.xticks(ind+width,states)
    plt.xticks(rotation=90)
    plt.bar(ind,name2,width,label=name_max2,color="r",align="center")
    plt.bar(ind+width,name1,width,label=name_max1,color="b",align="center")
    plt.xlabel('States')
    plt.ylabel('Vote Count')
    plt.legend()
    plt.tight_layout()
    plt.savefig("ComparativeVotes.pdf")
    plt.close()
DispBarPlot()

avg=[]
def compareVoteonBar():
    for numbs in sums:
        avg.append(float(format(numbs/sum(total_vote)*(100),'.3f')))
    sorted_sums=(sorted(avg)[::-1])
    colors=["r","b","yellow","#728FCE"]
    N=range(len(sorted_sums))
    plt.xticks(N,[str(item)+" "+"%" for item in sorted_sums])
    for nump in N:
        plt.bar(nump,sorted_sums[nump],width=0.75,color=colors[nump],align="center",label=nominees[avg.index(sorted_sums[nump])])
    plt.xlabel("Nominees")
    plt.ylabel("Vote Percentage")
    plt.legend()
    plt.tight_layout()
    plt.savefig("CompVotePercs.pdf")
    plt.close()
compareVoteonBar()

def obtainHistogram(liste):
    XListe=[str(number) for number in liste]
    Digits=[]
    for numby in XListe:
        Digits.append(float(numby[-1]))
        if float(numby)<=9 and float(numby)!=0:
            Filled=numby.zfill(2)[0]
            Digits.append(float(Filled))
        else:
            Digits.append(float(numby[-2:][0]))
    polar=[Digits.count(x)/len(Digits) for x in range(10)]
    return polar

def plotHistogram(histogram):
    M=range(10)
    plt.title("Histogram of least digits sign. digits")
    plt.axhline((sum(obtainHistogram(histogram))/len(obtainHistogram(histogram))),color="green",label="Mean",ls="dashed")
    plt.plot(M,obtainHistogram(histogram),color="red",label="Digit Dist.")
    plt.xlabel("Digits")
    plt.ylabel("Distrubition")
    plt.legend()
    plt.savefig("Histogram.pdf")
    plt.close()
plotHistogram(result)

def plotHistogramWithSample():
    option1=[random.randint(0, 99) for x in np.arange(10)]
    option2=[random.randint(0, 99) for x in np.arange(50)]
    option3=[random.randint(0, 99) for x in np.arange(100)]
    option4=[random.randint(0, 99) for x in np.arange(1000)]
    option5=[random.randint(0, 99) for x in np.arange(10000)]
    K=sum(obtainHistogram(result))/len(obtainHistogram(result))
    N=range(10)
    plt.title("Histogram of least digits sign. digits. Sample:1")
    plt.axhline((K),color="green",label="Mean",ls="dashed")
    plt.plot(N,obtainHistogram(option1),color="blue",label="Digit Dist.")
    plt.xlabel("Digits")
    plt.ylabel("Distrubition")
    plt.legend()
    plt.savefig("HistogramofSample1.pdf")
    plt.close()
    plt.title("Histogram of least digits sign. digits. Sample:2")
    plt.axhline((K),color="green",label="Mean",ls="dashed")
    plt.plot(N,obtainHistogram(option2),color="#728FCE",label="Digit Dist.")
    plt.xlabel("Digits")
    plt.ylabel("Distrubition")
    plt.legend()
    plt.savefig("HistogramofSample2.pdf")
    plt.close()
    plt.title("Histogram of least digits sign. digits. Sample:3")
    plt.axhline((K),color="green",label="Mean",ls="dashed")
    plt.plot(N,obtainHistogram(option3),color="k",label="Digit Dist.")
    plt.xlabel("Digits")
    plt.ylabel("Distrubition")
    plt.legend()
    plt.savefig("HistogramofSample3.pdf")
    plt.close()
    plt.title("Histogram of least digits sign. digits. Sample:4")
    plt.axhline((K),color="green",label="Mean",ls="dashed")
    plt.plot(N,obtainHistogram(option4),color="m",label="Digit Dist.")
    plt.xlabel("Digits")
    plt.ylabel("Distrubition")
    plt.legend()
    plt.savefig("HistogramofSample4.pdf")
    plt.close()
    plt.title("Histogram of least digits sign. digits. Sample:5")
    plt.axhline((K),color="green",label="Mean",ls="dashed")
    plt.plot(N,obtainHistogram(option5),color="yellow",label="Digit Dist.")
    plt.xlabel("Digits")
    plt.ylabel("Distrubition")
    plt.legend()
    plt.savefig("HistogramofSample5.pdf")
    plt.close()
plotHistogramWithSample()

def calculateMSE(list1,list2):
    MSE=[]
    for num in range(len(list1)):
        MSE.append((list1[num]-list2[0])**2)
    sumMSE=sum(MSE)
    return(sumMSE)

def MSEvalue(graph):
    b=obtainHistogram(graph)
    a=[0.1]*len(b)
    return calculateMSE(obtainHistogram(graph),a)
MSEvalue(result)

def compareMSEs(argument):
    obj=[[random.randint(1,99) for x in range(0,len(result))] for i in range(0,10000)]
    bla=[]
    greater=[]
    smaller=[]
    for list in obj:
        bla.append([MSEvalue(list)])
    for null in bla:
        if null[0]>=MSEvalue(argument):
            greater.append(null[0])
        else:
            smaller.append(null[0])
    return [len(greater),len(smaller)]

Greater=[compareMSEs(result)[0]]
Smaller=[compareMSEs(result)[1]]
pvalue=[Smaller[0]/10000]
significancelevel=0.05

with open("myAnswer.txt","w") as text:
    print("MSE value of 2012 USA election is",MSEvalue(result))
    text.write("MSE value of 2012 USA election is"+" "+str(MSEvalue(result))+"\n")
    print("The number of MSE of random samples which are larger than or equal to USA election MSE is",Greater[0])
    text.write("The number of MSE of random samples which are larger than or equal to USA election MSE is"+" "+str(Greater[0])+"\n")
    print("The number of MSE of random samples which are smaller than USA election MSE is",Smaller[0])
    text.write("The number of MSE of random samples which are smaller than USA election MSE is"+" "+str(Smaller[0])+"\n")
    print("2012 USA election rejection level p is",pvalue[0])
    text.write("2012 USA election rejection level p is"+" "+str(pvalue[0])+"\n")
    if pvalue[0] > significancelevel:
        print("Finding: There is no statistical evidence to reject null hypothesis")
        text.write("Finding: There is no statistical evidence to reject null hypothesis")
    else:
        print("Finding: We reject the null hypothesis as p="+str(pvalue[0])+"level")
        text.write("Finding: We reject the null hypothesis as p="+str(pvalue[0])+"level")
