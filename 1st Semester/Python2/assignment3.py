#------------------------------------------------------------#
# Student Name:Buğra Tuncer
# Student ID:21527395
# BBM103 Introduction to Programming Laboratory I, Fall 2016
# Assignment 3: Mission: Save the Earth
#------------------------------------------------------------#
import sys
dictionary=open(sys.argv[1],"r")
transmission=open(sys.argv[2],"r")
granite=open(sys.argv[3],"r")
translated=open("binarian_message.txt","w")
infos=open("computations.txt","w")
message=open("message.txt","w")

binarian_to_english={}
english_to_binarian={}
for line in dictionary:
    x=line.strip("\n").split(" ")
    a=x[0]
    b=x[1]
    binarian_to_english[a]=b
    english_to_binarian[b]=a

obsidian=transmission.read().splitlines()
lel=[]
for lines in obsidian:
    if not lines.lstrip().startswith(("#","+")):
        lel.append(str(lines))

astrophysical_data=[]
metadata=[]
for linex in obsidian:
    if linex.lstrip().startswith(("+")):
        astrophysical_data.append(linex)
    elif linex.lstrip().startswith(("#")):
        metadata.append(linex)


for words in lel:
    doctor=words.rstrip("\n").split()
    master=""
    for axel in doctor:
        try:
            axel=binarian_to_english[axel]
        except:
            axel=axel
        master=master+axel+" "
    print(master)
    translated.write(str(master)+"\n")

itemq=[]
for item in astrophysical_data:
    a=item.split(" ")
    itemq.extend(a)

a=english_to_binarian['temperature']
b=english_to_binarian['orbital-speed']
c=english_to_binarian['distance']
aone=(itemq.index(a)+1)
bone=(itemq.index(b)+1)
cone=(itemq.index(c)+1)

numbers=[]
decimal=[]
numbers.append(itemq[aone])
numbers.append(itemq[bone])
numbers.append(itemq[cone])
for i in numbers:
    decimal.append(int(i,2))

LightYear=("{:.4e}".format(float(9.4607*(10**12))))
Distance=[]
Temperature=[]
OrbitalSpeed=[]
Distance.append(float(LightYear)*float(decimal[2]))
Temperature.append(float(decimal[0]))
OrbitalSpeed.append(float(decimal[1]))

print("Data about binarian planet:")
infos.write("Data about binarian planet:"+"\n")
print("Distance from the Earth:",("{:.4e}".format(Distance[0])),"km")
infos.write("Distance from the Earth:"+" "+str("{:.4e}".format(Distance[0]))+" "+"km"+"\n")
print("Planet temperature:",Temperature[0],"degrees Celsius")
infos.write("Planet temperature:"+" "+str(Temperature[0])+" "+"degrees Celsius"+"\n")
print("Orbital speed:",OrbitalSpeed[0],"km/s")
infos.write("Orbital speed:"+" "+str(OrbitalSpeed[0])+" "+"km/s")

readwhat=granite.read().splitlines()
for word in readwhat:
    splinter=word.rstrip("\n").split()
    michalengelo=[]
    for number in splinter:
        try:
            number=int(number)
            michalengelo.append(str(bin(number)[2:]))
        except:
            number=number
            michalengelo.append(number)
    ash=""
    for rose in michalengelo:
        try:
            rose=english_to_binarian[rose.lower().rstrip(",""."" "";""!""?")]
        except:
            rose=rose.rstrip(",""."" "";""!""?")
        ash=ash+rose+" "
    print(ash)
    message.write(str(ash)+"\n")


granite.close()
dictionary.close()
transmission.close()
message.close()
translated.close()
infos.close()
