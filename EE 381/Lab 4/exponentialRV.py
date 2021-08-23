#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Oct 24 09:59:16 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 4
import numpy as np
import matplotlib.pyplot as plt

def ExpPDF(beta, X):
    f = ((1/beta)*np.exp(-(1/beta)*X))*np.ones(np.size(X))
    return f

def exponentialRV(beta, n):
    X = np.random.exponential(beta, n)
    
    #Plotting
    nbins = 30; #Number of bins
    edgecolor = 'w' #Color separating bars in the bargraph
    bins = [float(X) for X in np.linspace(0,5,nbins + 1)]
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
    
    #Plot the Exponential PDF
    f = ExpPDF(beta,b1)
    plt.plot(b1,f,'r')
    plt.title('1.2 PDF of a Random Variable "X"')
    plt.xlabel('X')
    plt.ylabel('PDF')
    
    #Calculate mean and deviation
    mu = np.mean(X)
    sigma = np.std(X)
    e_mean = beta
    e_std = beta
    print('Problem 1b:')
    print('Experimental Mean: ', mu)
    print('Theoretical Mean: ', e_mean)
    print('Experimental Standard Deviation: ', sigma)
    print('Theoretical Standard Deviation: ', e_std)
 
beta = 0.33
n = 10000
exponentialRV(beta, n)