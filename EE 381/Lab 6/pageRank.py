#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Nov 30 18:01:43 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 6

import numpy as np
import matplotlib.pyplot as plt

v1 = [.2, .2, .2, .2, .2]
v2 = [0, 0, 0, 0, 1]
transMatrix = np.matrix([[0, 1, 0, 0, 0], [0.5, 0, 0.5, 0, 0], [0.33, 0.33, 0, 0, 0.33], [1, 0, 0, 0, 0], [0, 0.33, 0.33, 0.33, 0]])

def pageRank(v):
    n = 20
    result = np.zeros((n, 5))
    initial = v
    result[0, :] = initial
    for i in range(0, n-1):
        result[i + 1, :] = np.matmul(result[i, :], transMatrix)
            
    nv = np.linspace(0, n, num=20)
    plt.figure()
    plt.plot(nv, result, marker='o', markersize=6)
    plt.title(('Google PageRank Algorithm: ', np.str(v)))
    plt.xlabel('Time step (n)')
    plt.ylabel('Probability of page visit')
    plt.legend((['A'], ['B'], ['C'], ['D'], ['E']))
    plt.show()

pageRank(v1)
pageRank(v2)

'''
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.lines as mlines

v1 = [.2, .2, .2, .2, .2]
v2 = [0, 0, 0, 0, 1]

def pageRank(v):
    n = 20
    N = 10000
    pageA = np.zeros(n)
    pageB = np.zeros(n)
    pageC = np.zeros(n)
    pageD = np.zeros(n)
    pageE = np.zeros(n)
    for i in range (0, N):
        roll = nSidedDie(v)
        index = roll
        for j in range (0, n):
            if index == 1:
                pageA[j] += 1
                roll = nSidedDie([0, 1, 0, 0, 0])
                index = roll
            if index == 2:
                pageB[j] += 1
                roll = nSidedDie([0.5, 0, 0.5, 0, 0])
                index = roll
            elif index == 3:
                pageC[j] += 1
                roll = nSidedDie([0.33, 0.33, 0, 0, 0.33])
                index = roll
            elif index == 4:
                pageD[j] += 1
                roll = nSidedDie([1, 0, 0, 0, 0])
                index = roll
            elif index == 5:
                pageE[j] += 1
                roll = nSidedDie([0, 0.33, 0.33, 0.33, 0])
                index = roll
    
    plt.scatter(np.arange(len(pageA)), pageA, color='b', edgecolors='b')
    plt.scatter(np.arange(len(pageB)), pageB, color='r', edgecolors='r')
    plt.scatter(np.arange(len(pageC)), pageC, color='g', edgecolors='g')
    plt.scatter(np.arange(len(pageD)), pageD, color='o', edgecolors='o')
    plt.scatter(np.arange(len(pageE)), pageE, color='p', edgecolors='p')
    plt.xticks(np.arange(len(pageA)), np.arange(1, len(pageA) + 1))
    plt.plot(pageA, 'b:')
    plt.plot(pageB, 'r:')
    plt.plot(pageC, 'g:')
    plt.plot(pageD, 'o:')
    plt.plot(pageE, 'p:')
    plt.ylabel('Probability')
    plt.xlabel('Step Number')
    plt.title('Google PageRank Algorithm')
    l1 = mlines.Line2D([], [], color='blue', marker='.', label='A', markersize=15)
    l2 = mlines.Line2D([], [], color='red', marker='.', label='B', markersize=15)
    l3 = mlines.Line2D([], [], color='green', marker='.', label='C', markersize=15)
    l4 = mlines.Line2D([], [], color='orange', marker='.', label='D', markersize=15)
    l5 = mlines.Line2D([], [], color='purple', marker='.', label='E', markersize=15)
    plt.legend(handles=[l1, l2, l3, l4, l5])
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

pageRank(v1)
pageRank(v2)
'''