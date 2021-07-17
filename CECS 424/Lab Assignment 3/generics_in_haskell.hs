--Christopher Masferrer
--011894127
--CECS 424 - 01 Spring 2020

import Data.Function (on)
import Data.List (sortBy)

-- sort a list of numbers
sortNumbers :: Ord a => [a] -> [a]
sortNumbers = sortBy(compare)

-- sort a list of people alphabetically    
sortAlpha :: Ord a => [(a, b)] -> [(a, b)]
sortAlpha = sortBy(compare `on` fst)

--sort a list of people by age
sortAge :: Ord b => [(a, b)] -> [(a, b)]
sortAge = sortBy (flip compare `on` snd)

-- use both algorithms to sort an array
main :: IO ()
main =  do

-- display the original list of numbers
putStr "Here is a list of numbers: \n"
let numbers = [645.32, 37.40, 76.30, 5.40, -34.23, 1.11, -34.94, 23.37, 635.46, -876.22, 467.73, 62.26]
print (numbers)

-- display the sorted version of the numbers list
putStr "\nHere is a sorted list of numbers: \n"
print (sortNumbers numbers)

-- create a list of people and display it
let people = [("Hal", 20),
          ("Susann", 31),
          ("Dwight", 19),
          ("Kassandra", 21),
          ("Lawrence", 25),
          ("Cindy", 22),
          ("Cory", 27),
          ("Mac", 19),
          ("Romana", 27),
          ("Doretha", 32),
          ("Danna", 20),
          ("Zara", 23),
          ("Rosalyn", 26),
          ("Risa", 24),
          ("Benny", 28),
          ("Juan", 33),
          ("Natalie", 25)]

putStr "\nHere is a list of people: \n"
print (people)

-- sort the list of people alphabetically and display
putStr "\nHere is a list of people sorted alphabetically: \n"
print(sortAlpha people)

--sort the list of people by age then alphabetically
putStr "\nHere is a list of people sorted by age: \n"
print(sortAge (sortAlpha people))