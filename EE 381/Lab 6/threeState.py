#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Nov 22 12:41:40 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 6
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.lines as mlines


def threeState():
    n = 15
    N = 10000
    firstRun = np.zeros(n)
    state1 = np.zeros(n)
    state2 = np.zeros(n)
    state3 = np.zeros(n)
    for i in range (0, N):
        index = 0
        roll = 0
        for j in range (0, n):
            if index == 0:
                roll = nSidedDie([1/4, 0, 3/4])
                index = roll
                firstRun[j] = index
            if index == 1:
                roll = nSidedDie([1/3, 1/3, 1/3])
                index = roll
                state1[j] += 1
                firstRun[j] = index
            elif index == 2:
                roll = nSidedDie([1/3, 1/6, 1/2])
                index = roll
                state2[j] += 1
                firstRun[j] = index
            elif index == 3:
                roll = nSidedDie([2/5, 1/5, 2/5])
                index = roll
                state3[j] += 1
                firstRun[j] = index
            
        if i == 0:
            plt.yticks([1, 2, 3])
            plt.scatter(np.arange(len(firstRun)), firstRun, color='r', edgecolors='b')
            plt.xticks(np.arange(len(firstRun)), np.arange(1, len(firstRun) + 1))
            plt.plot(firstRun, 'b:')
            plt.ylabel('states')
            plt.xlabel('steps')
            plt.title('Simulated run')
            plt.show()
    
    plt.scatter(np.arange(len(state1)), state1, color='b', edgecolors='b')
    plt.scatter(np.arange(len(state2)), state2, color='r', edgecolors='r')
    plt.scatter(np.arange(len(state3)), state3, color='g', edgecolors='g')
    plt.xticks(np.arange(len(state1)), np.arange(1, len(state1) + 1))
    plt.plot(state1, 'b:')
    plt.plot(state2, 'r:')
    plt.plot(state3, 'g:')
    plt.ylabel('Probability')
    plt.xlabel('Step Number')
    plt.title('Simulated three-state Markov Chain')
    l1 = mlines.Line2D([], [], color='blue', marker='.', label='State 1', markersize=15)
    l2 = mlines.Line2D([], [], color='red', marker='.', label='State 2', markersize=15)
    l3 = mlines.Line2D([], [], color='green', marker='.', label='State 3', markersize=15)
    plt.legend(handles=[l1, l2, l3])
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

threeState()