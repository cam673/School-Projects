#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Sep  5 09:06:58 2019

@author: christophermasferrer
"""
import numpy as np
n = 456976

def password_cracker(N, k, m):
    success = 0
    for i in range(0,N):
        pw = np.random.randint(0,n)
        hacker = np.random.randint(0,n,m * k)
        if pw in hacker:
            success += 1
    prob = success / N
    print('The chance that a hacker has at getting the password is: ' + str(prob))

#1st experiment
password_cracker(1000, 1, 70000)

#2nd experiment
password_cracker(1000, 7, 70000)

#3rd experiment
password_cracker(1000, 1, 322000)