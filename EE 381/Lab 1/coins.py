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

def MultiCoinToss(N):
    accum = 0
    for i in range(0, N):
        coin = np.random.randint(0, 2, 100)
        heads = sum(coin)
        if heads == 50:
            accum += 1
    prob = accum / N
    return prob
    

print(MultiCoinToss(100000))