#Christopher Masferrer
#011894127
#CECS 378
import random
import sys
import os

#store standard alphabet and key shift
standard = "abcdefghijklmnopqrstuvwxyz"
reverse = "zyxwvutsrqponmlkjihgfedcba"
keyShift = 0

#welcome user
print("Welcome to the message decrypter! I will now decrypt the following messages: ")

#decrypt message1
message1 = "fqjcb rwjwj vnjax bnkhj whxcq nawjv nfxdu mbvnu ujbbf nnc"
decrypt1 = ""

print("\nMessage 1: ", message1)
keyShift = 9
newPosition = 0
counter = 0

for i in message1:
    for j in standard:
        if i == j:
            newPosition = (counter - keyShift) % 26
            decrypt1 = decrypt1 + standard[newPosition]
        counter = counter + 1
    counter = 0

print("Message 1 Decrypted: ", decrypt1)

#decrypt message2
message2 = "oczmz vmzor jocdi bnojv dhvod igdaz admno ojbzo rcvot jprvi oviyv aozmo cvooj ziejt dojig toczr dnzno jahvi fdiyv xcdzq zoczn zxjiy"
decrypt2 = ""

print("\nMessage 2: ", message2)
keyShift = 21
newPosition = 0
counter = 0

for i in message2:
    for j in standard:
        if i == j:
            newPosition = (counter - keyShift) % 26
            decrypt2 = decrypt2 + standard[newPosition]
        counter = counter + 1
    counter = 0

print("Message 2 Decrypted: ", decrypt2)

#decrypt message3
message3 = "ejitp spawa qleji taiul rtwll rflrl laoat wsqqj atgac kthls iraoa twlpl qjatw jufrh lhuts qataq itats aittk stqfj cae"
decrypt3 = ""

print("\nMessage 3: ", message3)
keyShift = 25
newPosition = 0
counter = 0

for i in message3:
    for j in reverse:
        if i == j:
            newPosition = (counter - keyShift) % 26
            decrypt3 = decrypt3 + reverse[newPosition]
        counter = counter + 1
    counter = 0

print("Message 3 Decrypted: ", decrypt3)

#decrypt message4
message4 = "iyhqz ewqin azqej shayz niqbe aheum hnmnj jaqii yuexq ayqkn jbeuq iihed yzhni ifnun sayiz yudhe sqshu qesqa iluym qkque aqaqm oejjs hqzyu jdzqa diesh niznj jayzy uiqhq vayvq shsnj jejjz nshna hnmyt isnae sqfun dqzew qiead zevqi zhnjq shqze udqai jrmtq uishq ifnun siiqa suoij qqfni syyle iszhn bhmei squih nimnx hsead shqmr udquq uaqeu iisqe jshnj oihyy snaxs hqihe lsilu ymhni tyz"
decrypt4 = ""

print("\nMessage 4: ", message4)
keyShift = 9
newPosition = 0
counter = 0

for i in message4:
    for j in standard:
        if i == j:
            newPosition = (counter - keyShift) % 26
            decrypt4 = decrypt4 + standard[newPosition]
        counter = counter + 1
    counter = 0

print("Message 4 Decrypted: ", decrypt4)