#Christopher Masferrer
#011894127
#CECS 378
import random
import sys
import os
import binascii

menu = 9
submenu = 9
submenu2 = 9
bits = [123, 27]
binary = bytearray(bits)
item = 0

with open("SAVED.GAM", "rb+") as f:
    f.seek(3)
    f.write(b'\xAA')
f.close()

#Welcome user
print("Hello and Welcome to the Ultima 5 stat modifier!")

#enter menu
while menu != 0:
   print("Here are the following items that you can modify:")
   print("1. Keys")
   print("2. Skull Keys")
   print("3. Gems")
   print("4. Black Badges")
   print("5. Magic Carpets")
   print("6. Magic Axes")
   print("7. Gold")
   print("8. Player Stats")
   print("0. Exit")
   select = input("Enter the value of the stat you would like to change: ")
   menu = int(select)
   #jump to the menu option the user inputs
   if(menu == 1):
       select = input("From (0-100) - Enter the number of keys you would like to add: ")
       item = hex(int(select))[2:]
       binary = str(item).encode()
       with open("SAVED.GAM", "rb+") as f:
           f.seek(518)
           f.write(binary)
       f.close()
       print("Process complete. Returning to main menu.")
   if(menu == 2):
       select = input("From (0-100) - Enter the number of skull keys you would like to add: ")
       item = hex(int(select))[2:]
       binary = str(item).encode()
       with open("SAVED.GAM", "rb+") as f:
           f.seek(519)
           f.write(binary)
       f.close()
       print("Process complete. Returning to main menu.")
   if(menu == 3):
       select = input("From (0-100) - Enter the number of gems you would like to add: ")
       item = hex(int(select))[2:]
       binary = str(item).encode()
       with open("SAVED.GAM", "rb+") as f:
           f.seek(519)
           f.write(binary)
       f.close()
       print("Process complete. Returning to main menu.")
   if(menu == 4):
       select = input("From (0-100) - Enter the number of black badges you would like to add: ")
       item = hex(int(select))[2:]
       binary = str(item).encode()
       with open("SAVED.GAM", "rb+") as f:
           f.seek(519)
           f.write(binary)
       f.close()
       print("Process complete. Returning to main menu.")
   if(menu == 5):
       select = input("From (0-100) - Enter the number of magic carpets you would like to add: ")
       item = hex(int(select))[2:]
       binary = str(item).encode()
       with open("SAVED.GAM", "rb+") as f:
           f.seek(519)
           f.write(binary)
       f.close()
       print("Process complete. Returning to main menu.")
   if(menu == 6):
       select = input("From (0-100) - Enter the number of magic axes you would like to add: ")
       item = hex(int(select))[2:]
       binary = str(item).encode()
       with open("SAVED.GAM", "rb+") as f:
           f.seek(576)
           f.write(binary)
       f.close()
       print("Process complete. Returning to main menu.")
   if(menu == 7):
       select = input("From (0-9999) - Enter the number of gold you would like to add: ")
       item = hex(int(select))[2:]
       binary = str(item).encode()
       with open("SAVED.GAM", "rb+") as f:
           f.seek(516)
           f.write(binary)
       f.close()
       print("Process complete. Returning to main menu.")
   if(menu == 8):
       #character modification menu
       while submenu != 0:
           print("Select a character to modify: ")
           print("1. You")
           print("2. Shamino")
           print("3. Iolo")
           print("4. Mariah")
           print("5. Geoffrey")
           print("6. Jaana")
           print("7. Julia")
           print("8. Dupre")
           print("9. Katrina")
           print("10. Sentri")
           print("11. Gwenno")
           print("12. Johne")
           print("13. Gorn")
           print("14. Maxwell")
           print("15. Toshi")
           print("16. Saduj")
           print("0. Exit")
           select = input("Enter the value here: ")
           submenu = int(select)
           #Jump to character that the user wants to modify
           if(submenu == 1):
               while submenu2 != 0:
                   print("Select the stat you would like to change for You: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(14)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(16)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(15)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(18)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(20)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(22)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 2):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Shamino: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(46)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(48)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(47)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(50)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(52)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(54)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 3):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Iolo: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(78)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(80)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(79)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(82)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(84)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(86)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 4):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Mariah: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(110)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(112)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(111)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(114)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(116)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(118)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 5):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Geoffrey: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(142)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(144)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(143)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(146)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(148)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(150)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 6):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Jaana: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(174)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(176)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(175)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(178)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(180)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(182)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 7):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Julia: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(206)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(208)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(207)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(210)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(212)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(214)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 8):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Dupre: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(238)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(240)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(239)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(242)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(244)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(246)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 9):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Katrina: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(270)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(272)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(271)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(274)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(276)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(278)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 10):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Sentri: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(302)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(304)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(303)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(306)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(308)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(310)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 11):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Gweeno: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(334)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(336)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(335)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(338)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(340)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(342)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 12):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Johne: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(366)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(368)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(367)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(370)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(372)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(374)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 13):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Gorn: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(398)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(400)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(399)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(402)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(404)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(406)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 14):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Maxwell: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(430)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(432)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(431)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(434)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(436)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(438)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 15):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Toshi: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(462)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(464)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(463)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(466)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(468)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(470)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 16):
               while submenu2 != 0:
                   print("Select the stat you would like to change for Saduj: ")
                   print("1. Strength")
                   print("2. Intelligence")
                   print("3. Dexterity")
                   print("4. Health")
                   print("5. Max Health")
                   print("6. Experience")
                   print("0. Exit")
                   select = input("Enter the value here: ")
                   submenu2 = int(select)
                   if (submenu2 == 1):
                       select = input("From (0-99) - Enter the number of strength you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(494)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 2):
                       select = input("From (0-99) - Enter the number of intelligence you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(496)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 3):
                       select = input("From (0-99) - Enter the number of dexterity you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(495)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 4):
                       select = input("From (0-999) - Enter the number of health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(498)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 5):
                       select = input("From (0-999) - Enter the number of max health you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(500)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 6):
                       select = input("From (0-9999) - Enter the number of experience you would like to add: ")
                       item = hex(int(select))[2:]
                       binary = str(item).encode()
                       with open("SAVED.GAM", "rb+") as f:
                           f.seek(502)
                           f.write(binary)
                       f.close()
                       print("Process complete. Returning to stat menu.")
                   if (submenu2 == 0):
                       print("Returning to character select menu.")
               submenu2 = 9
           if(submenu == 0):
               print("Returning to menu")
       print("Exiting submenu")


   if(menu == 0):
       print("Exiting menu")
   submenu = 9


print("Goodbye.")