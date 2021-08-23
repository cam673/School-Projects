#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Nov 10 08:21:27 2019

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
    
    sMean(2.78, 4.6, 5)
    sMean(2.02, 2.7, 40)
    sMean(1.98, 2.62, 120)

def sMean(t95, t99, size):
    trials = 10000
    successZ95 = 0
    successZ99 = 0
    successT95 = 0
    successT99 = 0
    sample = size
    for i in range (0, trials):
        y = B[r.sample(range(N), sample)]
        yMean = np.sum(y)/sample
        total = 0
        for n in range(0, len(y)):
            total = total + (y[n]-yMean) ** 2
        yS = total/(sample-1)
        yS = m.sqrt(yS)
        yStd = yS/m.sqrt(sample)
        
        yTop95 = yMean + 1.96*(yStd)
        yBottom95 = yMean - 1.96*(yStd)
        yTop99 = yMean + 2.58*(yStd)
        yBottom99 = yMean - 2.58*(yStd)
        
        tTop95 = yMean + t95*(yStd)
        tBottom95 = yMean - t95*(yStd)
        tTop99 = yMean + t99*(yStd)
        tBottom99 = yMean - t99*(yStd)
        
        if yBottom95 <= mu and yTop95 >= mu:
            successZ95 += 1
        if yBottom99 <= mu and yTop99 >= mu:
            successZ99 += 1
        if tBottom95 <= mu and tTop95 >= mu:
            successT95 += 1
        if tBottom99 <= mu and tTop99 >= mu:
            successT99 += 1
    
    print('Success Rate using normal, sample = %d,' % sample, '95% confidence interval')
    print(successZ95/trials)
    print('Success Rate using normal, sample = %d,' % sample, '99% confidence interval')
    print(successZ99/trials)
    print('Success Rate using student t, sample = %d,' % sample, '95% confidence interval')
    print(successT95/trials)
    print('Success Rate using student t, sample = %d,' % sample, '99% confidence interval')
    print(successT99/trials)
    print('')
    
sSize()