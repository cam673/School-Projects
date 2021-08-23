#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Sep 20 18:13:41 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 1
import numpy as np

p0 = 0.35
e0 = 0.04
e1 = 0.07

def nSidedDie(p):
    N = 1
    n = np.size(p)
    cs = np.cumsum(p)
    cp = np.append(0,cs)
    
    for j in range(0, N):
        r = np.random.rand()
        for k in range (0, n):
            if r > cp[k] and r <= cp[k + 1]:
                d = k+1
        return d

def transmissionError():
    N = 100000
    count = 0
    for j in range(0, N):
        S = nSidedDie([p0, 1 - p0])
        if S == 1:
            R = nSidedDie([e1, 1 - e1])
        else:
            R = nSidedDie([1 - e0, e0])
        
        if S != R:
            count += 1
    prob = count / N
    print("Probability of an error: " + str(prob))

transmissionError()
#result: 0.94814