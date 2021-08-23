#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov  7 13:18:04 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 5
import numpy as np
import matplotlib.pyplot as plt
import random as r
import math as m

N = 1200000 
mu = 45 
sig = 3 
B = np.random.normal(mu,sig,N)

def sSize():
    n = 180
    mean = [None] * n
    top95 = [None] * n
    bottom95 = [None] * n
    top99 = [None] * n
    bottom99 = [None] * n
    for i in range (0,n):
        counter = i+1 
        x = B[r.sample(range(N), counter)]
        mean[i] = np.sum(x)/counter
        std = sig/m.sqrt(counter)
        top95[i] = mu + 1.96*(std)
        bottom95[i] = mu - 1.96*(std)
        top99[i] = mu + 2.58*(std)
        bottom99[i] = mu - 2.58*(std)
   
    coll = [x for x in range(1, counter+1)] 
    
    plt.close('all')
    
    fig1 = plt.figure(1)
    plt.scatter(coll, mean, c = 'Blue', marker = 'x')
    plt.plot(coll, top95, 'r--')
    plt.plot(coll, bottom95, 'r--')
    plt.title('Sample Means & 95% confidence intervals')
    plt.xlabel('Sample Size')
    plt.ylabel('x_bar')
    
    fig2 = plt.figure(2)
    plt.scatter(coll, mean, c = 'Blue', marker = 'x')
    plt.plot(coll, top99, 'g--')
    plt.plot(coll, bottom99, 'g--')
    plt.title('Sample Means & 99% confidence intervals')
    plt.xlabel('Sample Size')
    plt.ylabel('x_bar')

sSize()