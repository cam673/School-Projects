#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Oct 23 15:52:59 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 4
import numpy as np
import matplotlib.pyplot as plt

def UnifPDF(a, b, X):
    f = (1/abs(b-a))*np.ones(np.size(X))
    return f

def uniformRV(a, b, n):
    X = np.random.uniform(a, b, n)
    
    #Plotting
    nbins = 30; #Number of bins
    edgecolor = 'w' #Color separating bars in the bargraph
    bins = [float(X) for X in np.linspace(a,b,nbins + 1)]
    h1, bin_edges = np.histogram(X, bins,density = True)
    #Define points on the horizontal axis
    be1 = bin_edges[0:np.size(bin_edges)-1]
    be2 = bin_edges[1:np.size(bin_edges)]
    b1 = (be1 + be2)/2
    barwidth = b1[1] -b1[0] #Width of bars in the graph
    plt.close('all')
    
    #Plot the bar graph
    fig1 = plt.figure(1)
    plt.bar(b1,h1,width = barwidth,edgecolor=edgecolor)
    
    #Plot the Uniform PDF
    f = UnifPDF(a,b,b1)
    plt.plot(b1,f,'r')
    plt.title('1.1 PDF of a Random Variable "X"')
    plt.xlabel('X')
    plt.ylabel('PDF')
    
    #Calculate mean and deviation
    mu = np.mean(X)
    sigma = np.std(X)
    e_mean = (a+b)/2
    e_std = ((b-a)**(2))/12
    print('Problem 1a:')
    print('Experimental Mean: ', mu)
    print('Theoretical Mean: ', e_mean)
    print('Experimental Standard Deviation: ', sigma)
    print('Theoretical Standard Deviation: ', e_std)
 
a = 2.0
b = 4.0
n = 10000
uniformRV(a, b, n)