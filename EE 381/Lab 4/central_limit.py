#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Oct 27 11:15:18 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 4
import numpy as np
import matplotlib.pyplot as plt

#Variables
a = 2.0
b = 5.0
N = 10000
mu_x = (a + b) / 2
sig_x = np.sqrt((b - a) ** 2/12)
X = np.zeros((N, 1))

#Generate the values of the RV X
def generate(a, b, nbooks, N):
    for k in range(0, N):
        x = np.random.uniform(a, b, nbooks)
        w = np.sum(x)
        X[k] = w
        
    #Create bins and histogram
    nbins = 30
    edgecolor = 'w'
    bins = [float(x) for x in np.linspace(nbooks*a, nbooks*b, nbins + 1)]
    h1, bin_edges = np.histogram(X, bins, density = True)
    #Define points on the horizontal axis
    be1 = bin_edges[0:np.size(bin_edges) - 1]
    be2 = bin_edges[1:np.size(bin_edges)]
    b1 = (be1 + be2) / 2
    barwidth = b1[1] - b1[0]
    plt.close('all')
    
    #Plot the bar graph
    fig1 = plt.figure(1)
    plt.bar(b1, h1, width = barwidth, edgecolor = edgecolor)
    
    #Calculate Gaussian Function
    f = gaussian(mu_x*nbooks, sig_x*np.sqrt(nbooks), b1)
    plt.plot(b1, f, 'r')
    plt.title('PDF of book stack height and comparison with Gaussian')
    plt.xlabel('Book stack height for n = ' + str(nbooks) + ' books')
    plt.ylabel('PDF')
    plt.show()
    
    #Calculate mean
    mu_mean = np.mean(X)
    print('Mu mean: ', mu_mean)
    sig_mean = np.std(X)
    print('Sigma mean: ', sig_mean)

#Plot the gaussian function
def gaussian(mu, sig, z):
    f = np.exp(-(z-mu) **2/ (2*sig**2)) / (sig*np.sqrt(2*np.pi))
    return f

#n = 1, 5, 15
generate(a, b, 1, N)
generate(a, b, 5, N)
generate(a, b, 15, N)