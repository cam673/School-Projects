#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Sep  3 15:12:05 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 1
import numpy as np
import matplotlib.pyplot as plt


def sum2dice(N):
    count = [None] * N
    for i in range(0, N):
        complete = 1
        counter = 0
        while complete:
            dice1 = np.random.randint(1, 7)  # represents 6 sided dice
            dice2 = np.random.randint(1, 7)
            sum = dice1 + dice2  # summation of 2 dice
            counter += 1
            if sum == 7:  # if sum is 7 success
                complete = 0  # end while
                count[i] = counter

    b = range(1, 30)
    sb = np.size(b)
    h1, bin_edges = np.histogram(count, bins=b)
    b1 = bin_edges[0:sb - 1]
    plt.close('all')

    fig1 = plt.figure(1)
    p1 = h1 / N
    plt.stem(b1, p1)
    plt.title('Sum of 2 Dice is 7: PMF')
    plt.xlabel('Number of rolls to get 7')
    plt.ylabel('Probability')


print(sum2dice(100000))