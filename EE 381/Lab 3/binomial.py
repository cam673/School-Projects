#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct  7 09:02:08 2019

@author: christophermasferrer
"""

#Christopher Masferrer
#EE 381
#Lab 3
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import binom

def binomial():
    p = 0.1 * 0.1 * 0.1
    q = 1 - p
    n = 1000
    k = np.arange(0,20)
    y = binom.pmf(k, n, p)

    #Plots and labels
    plt.stem(k, y)
    plt.title('Bernoulli Trials: PMF - Binomial Formula', fontsize = 14, fontweight = 'bold')
    plt.xlabel('Number of successes in n = 1000 trials', fontsize = 14)
    plt.ylabel('Probability', fontsize = 14)
    plt.show()


binomial()