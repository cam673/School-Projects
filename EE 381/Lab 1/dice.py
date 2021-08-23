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

def nSidedDie(p):
    N = 10000
    n = np.size(p)
    cs = np.cumsum(p)
    cp = np.append(0,cs)
    
    for j in range(0, N):
        r = np.random.rand()
        for k in range (0, n):
            if r > cp[k] and r <= cp[k + 1]:
                d = k+1
        return d

def graph(p):
    N = 10000
    s = np.zeros((N,1))
    #
    for i in range(0,N):
        r=nSidedDie(p)
        s[i]=r
    
    #Plotting
    b= range(1,np.size(p)+2)
    sb = np.size(b)
    h1, bin_edges = np.histogram(s, bins = b)
    b1 = bin_edges[0 : sb - 1]
    plt.close('all')
    prob = h1/N
    #Plots and labels
    plt.stem(b1, prob, use_line_collection= True)
    plt.title('PMF for an n-sided die', fontsize = 14, fontweight = 'bold')
    plt.xlabel('Number on the face of the die', fontsize = 14)
    plt.ylabel('Probability', fontsize = 14)
    plt.xticks(b1)
    plt.show()

p = [0.10, 0.15, 0.20, 0.35, 0.20]
graph(p)
