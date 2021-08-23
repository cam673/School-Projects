#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Dec  5 09:36:16 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 6
import numpy as np

def absorption():
    n = 15
    N = 10000
    state0 = 0
    state4 = 0
    for i in range(0, N):
        roll = nSidedDie([0, 0, 1, 0, 0])
        index = roll - 1
        for j in range (0, n):
            if index == 0:
                roll = nSidedDie([1, 0, 0, 0, 0])
                index = roll - 1
            elif index == 1:
                roll = nSidedDie([2/3, 0, 1/3, 0, 0])
                index = roll - 1
            elif index == 2:
                roll = nSidedDie([0, 3/5, 0, 2/5, 0])
                index = roll - 1
            elif index == 3:
                roll = nSidedDie([0, 0, 3/10, 0, 7/10])
                index = roll - 1
            elif index == 4:
                roll = nSidedDie([0, 0, 0, 0, 1])
                index = roll - 1
                
        if index == 0:
            state0 += 1
        else:
            state4 += 1
            
    print("State 0 Successes: ", np.str(state0))
    print("State 4 Successes: ", np.str(state4))

def nSidedDie(p):
    n = np.size(p)

    cs = np.cumsum(p)
    cp = np.append(0,cs)
    
    r = np.random.rand()
    for k in range (0, n):
        if r > cp[k] and r <= cp[k + 1]:
            d = k+1
    return d

absorption()