#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Oct  6 14:57:23 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 3
import numpy as np
import matplotlib.pyplot as plt

def trials(c, p):
    N = 10000
    n = 1000
    
    X = np.zeros((N,1))
    
    for j in range(0, N):
        count = 0
        x1 = np.random.choice(c,n,p=p)
        x2 = np.random.choice(c,n,p=p)
        x3 = np.random.choice(c,n,p=p)
        for k in range (0, n):
            if x1[k] == 1 and x2[k] == 2 and x3[k] == 3:
                count += 1
        X[j] = count

    #Plotting
    b= range(0, 20)
    sb = np.size(b)
    h1, bin_edges = np.histogram(X, bins = b)
    b1 = bin_edges[0 : sb - 1]
    plt.close('all')
    prob = h1/N
    #Plots and labels
    plt.stem(b1, prob, use_line_collection= True)
    plt.title('Bernoulli Trials: PMF - Experimental Results', fontsize = 14, fontweight = 'bold')
    plt.xlabel('Number of successes in n = 1000 trials', fontsize = 14)
    plt.ylabel('Probability', fontsize = 14)
    plt.xticks(b1)
    plt.show()

c = [1, 2, 3, 4, 5, 6]
p=[0.1, 0.1, 0.1, 0.3, 0.2, 0.2]
trials(c, p)
