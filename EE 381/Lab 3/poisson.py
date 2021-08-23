#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Oct  9 08:51:29 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 3
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import poisson

def poisson_app():
    n = 1000
    p = 0.1*0.1*0.1
    lamda = n * p
    k = np.arange(0, 20)
    y = poisson.pmf(k, lamda)
    
    #Plots and labels
    plt.stem(k, y)
    plt.title('Bernoulli Trials: PMF - Poisson Approximation', fontsize = 14, fontweight = 'bold')
    plt.xlabel('Number of successes in n = 1000 trials', fontsize = 14)
    plt.ylabel('Probability', fontsize = 14)
    plt.show()

poisson_app()