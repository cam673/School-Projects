#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 21 08:42:59 2019

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
    
def probabilityRS():
    N = 100000
    count = 0
    for j in range(0, N):
        S = 1
        R = nSidedDie([e1, 1 - e1])
        
        if S == R:
            count += 1
    prob = count / N
    print("Conditional probability P(R=1|S=1): " + str(prob))

probabilityRS()