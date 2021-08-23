#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Sep 26 10:25:18 2019

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
    
def eTransmission():
    N = 100000
    count = 0
    for j in range(0, N):
        S = nSidedDie([p0, 1 - p0])
        R = 0
        if S == 1:
            R1 = nSidedDie([e1, 1 - e1])
            R2 = nSidedDie([e1, 1 - e1])
            R3 = nSidedDie([e1, 1 - e1])
        else:
            R1 = nSidedDie([1 - e0, e0])
            R2 = nSidedDie([1 - e0, e0])
            R3 = nSidedDie([1 - e0, e0])
        
        R = R1 + R2 + R3
        
        if R >= 2:
            R = 1
        else:
            R = 0
        
        if S != R:
            count += 1
    prob = count / N
    print("Probability of an error: " + str(prob))

eTransmission()