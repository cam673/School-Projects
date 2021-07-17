--Christopher Masferrer
--011894127
--CECS 424 - 01 Spring 2020

-- quicksort algorithm
qsort :: (Ord a) => [a] -> [a]
qsort [] = [] -- if list is empty return empty list
qsort (x:xs) =   -- use starting element as the pivot
    let smallerSorted = qsort [a | a <- xs, a <= x] -- grab all values smaller than x and sort them
        biggerSorted = qsort [a | a <- xs, a > x]   -- grab all values larger than x and sort them
    in  smallerSorted ++ [x] ++ biggerSorted -- combine the results

-- mergesort algorithm
-- combine elements
merge [] [] = [] -- if list is empty return empty list
merge [] ys = ys -- return right side
merge xs [] = xs -- return left side
merge (x:xs) (y:ys) | x <= y     = x : merge xs (y : ys) -- left side is smaller and is next in the list 
                    | otherwise  = y: merge (x : xs) ys -- right side is smaller and is next in the list

-- separate elements
split :: [a] -> ([a], [a])
split xs = (take n xs, drop n xs) -- split the array into two parts
   where n = (length xs) `div` 2  -- find the center index of the array

-- sorting the array
msort :: (Ord a) => [a] -> [a]
msort [] = [] -- if list is empty return empty list
msort xs -- split the array and sort the left and right sides of the center
  | (length xs) > 1 = merge (msort ls) (msort rs) -- sort left and right sides of the array
  | otherwise = xs -- return the array if it is size 1 or empty
  where (ls, rs) = split xs -- split the array into two parts

-- use both algorithms to sort an array
main :: IO ()
main =  do

putStr "Sorted List using quicksort "
print (qsort[4, 65, 2, -31, 0, 99, 2, 83, 782, 1])

putStr "Sorted List using mergesort "
print (msort[4, 65, 2, -31, 0, 99, 2, 83, 782, 1])