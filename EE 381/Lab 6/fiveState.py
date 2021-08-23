#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Dec  4 21:49:22 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 6
import numpy as np
import matplotlib.pyplot as plt

def fiveState():
    n = 15
    singleRun = np.zeros(n)
    roll = nSidedDie([0, 1/3, 1/3, 1/3, 0])
    index = roll - 1
    for i in range (0, n):
        if index == 0:
            singleRun[i] = index
            roll = nSidedDie([1, 0, 0, 0, 0])
            index = roll - 1
        elif index == 1:
            singleRun[i] = index
            roll = nSidedDie([2/3, 0, 1/3, 0, 0])
            index = roll - 1
        elif index == 2:
            singleRun[i] = index
            roll = nSidedDie([0, 3/5, 0, 2/5, 0])
            index = roll - 1
        elif index == 3:
            singleRun[i] = index
            roll = nSidedDie([0, 0, 3/10, 0, 7/10])
            index = roll - 1
        elif index == 4:
            singleRun[i] = index
            roll = nSidedDie([0, 0, 0, 0, 1])
            index = roll - 1
            
    plt.yticks([0, 1, 2, 3, 4])
    plt.scatter(np.arange(len(singleRun)), singleRun, color='r', edgecolors='b')
    plt.xticks(np.arange(len(singleRun)), np.arange(1, len(singleRun) + 1))
    plt.plot(singleRun, 'b:')
    plt.ylabel('states')
    plt.xlabel('steps')
    plt.title('Five-State Markov Chain')
    plt.show()

def nSidedDie(p):
    n = np.size(p)

    cs = np.cumsum(p)
    cp = np.append(0,cs)
    
    r = np.random.rand()
    for k in range (0, n):
        if r > cp[k] and r <= cp[k + 1]:
            d = k+1
    return d

fiveState()