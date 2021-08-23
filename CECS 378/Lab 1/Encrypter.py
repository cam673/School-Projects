#Christopher Masferrer
#011894127
#CECS 378
import random
import sys
import os

#Store standard alphabet and create a key
standard = "abcdefghijklmnopqrstuvwxyz"
key = "steak"
ciphertext = "steakbcdfghijlmnopqruvwxyz"
#counter will be used to print out the correct ciphertext letter based on the current index position of standard
counter = 0

#Welcome message to introduce program and key that will be used
print("Welcome to the message encrypter. The following key will be used to encrypt the following messages:", key)

#Display the messages that will be encrypted followed by the encrypted version of the message

#message 1

#store message 1 and create encrypted variable
message1 = "he who fights with monsters should look to it that he himself does not become a monster and if you gaze long into an abyss the abyss also gazes into you"
encrypt1 = ""

#print out original message
print("\nMessage 1: ", message1)
#encrypt message 1 using ciphertext and store the results in encrypt1
for i in message1:
    for j in standard:
        if i == j:
            encrypt1 = encrypt1 + ciphertext[counter]
        counter = counter + 1
    counter = 0

#print out encrypted message
print("Message 1 encrypted:", encrypt1)

#message 2

#store message 2 and create encrypted variable
message2 = "there is a theory which states that if ever anybody discovers exactly what the universe is for why it is here it will instantly disappear and be replaced by something even more bizzare and inexplicable there is another theory which states that this has already happened"
encrypt2 = ""

#print out original message
print("\nMessage 2: ", message2)
#encrypt message 2 using ciphertext and store the results in encrypt2
for i in message2:
    for j in standard:
        if i == j:
            encrypt2 = encrypt2 + ciphertext[counter]
        counter = counter + 1
    counter = 0

#print out encrypted message
print("Message 2 encrypted:", encrypt2)

#message 3

#store message 3 and create encrypted variable
message3 = "whenever i find myself growing grim about the mouth whenever it is a damp drizzly november in my soul whenever i find myself involuntarily pausing before coffin warehouses and bringing up the rear of every funeral i meet and especially whenever my hypos get such an upper hand of me that it requires a strong moral principle to prevent me from deliberately stepping into the street and methodically knocking peoples hats off then i account it high time to get to sea as soon as i can"
encrypt3 = ""

#print out original message
print("\nMessage 3: ", message3)
#encrypt message 3 using ciphertext and store the results in encrypt3
for i in message3:
    for j in standard:
        if i == j:
            encrypt3 = encrypt3 + ciphertext[counter]
        counter = counter + 1
    counter = 0

#print out encrypted message
print("Message 3 encrypted:", encrypt3)

#ask user for new key
key = input("\nPlease enter a new key: ")

ciphertext = key

for i in standard:
    if i not in ciphertext:
        ciphertext = ciphertext + i

print("Here is the new ciphertext", ciphertext)
print("The following key will be used to encrypt the same messages:", key)

#message 1

#store message 1 and create encrypted variable
message1 = "he who fights with monsters should look to it that he himself does not become a monster and if you gaze long into an abyss the abyss also gazes into you"
encrypt1 = ""

#print out original message
print("\nMessage 1: ", message1)
#encrypt message 1 using ciphertext and store the results in encrypt1
for i in message1:
    for j in standard:
        if i == j:
            encrypt1 = encrypt1 + ciphertext[counter]
        counter = counter + 1
    counter = 0

#print out encrypted message
print("Message 1 encrypted:", encrypt1)

#message 2

#store message 2 and create encrypted variable
message2 = "there is a theory which states that if ever anybody discovers exactly what the universe is for why it is here it will instantly disappear and be replaced by something even more bizzare and inexplicable there is another theory which states that this has already happened"
encrypt2 = ""

#print out original message
print("\nMessage 2: ", message2)
#encrypt message 2 using ciphertext and store the results in encrypt2
for i in message2:
    for j in standard:
        if i == j:
            encrypt2 = encrypt2 + ciphertext[counter]
        counter = counter + 1
    counter = 0

#print out encrypted message
print("Message 2 encrypted:", encrypt2)

#message 3

#store message 3 and create encrypted variable
message3 = "whenever i find myself growing grim about the mouth whenever it is a damp drizzly november in my soul whenever i find myself involuntarily pausing before coffin warehouses and bringing up the rear of every funeral i meet and especially whenever my hypos get such an upper hand of me that it requires a strong moral principle to prevent me from deliberately stepping into the street and methodically knocking peoples hats off then i account it high time to get to sea as soon as i can"
encrypt3 = ""

#print out original message
print("\nMessage 3: ", message3)
#encrypt message 3 using ciphertext and store the results in encrypt3
for i in message3:
    for j in standard:
        if i == j:
            encrypt3 = encrypt3 + ciphertext[counter]
        counter = counter + 1
    counter = 0

#print out encrypted message
print("Message 3 encrypted:", encrypt3)