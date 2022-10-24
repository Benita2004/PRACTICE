# -*- coding: utf-8 -*-
"""
Created on Fri Oct 21 12:45:55 2022

@author: HP EliteBook
"""

def single_int(num1):
    num1=int(input("enter what is the value:"))
    if num1 in range (0,100):
        print("true")
    else:
        print("false") 
        
single_int(7)
    
def string_count(string):
    global uppercase
    uppercase = 0
    global lowercase
    lowercase = 0
    for i in string:
        if i.islower():
            lowercase = lowercase + 1
        elif i.isupper():
            uppercase +=1
            
   # lowercase=enterStr.isupper()
    
    print("the number of uppercase",uppercase,("the number of lowercase", lowercase))
    
enterStr = input("Please enter a string: ")
string_count(enterStr)
                
        
 print(ord("A"))
 
def temp_fahrenheit(celcius1):
    celcius1=int(input("enter what is the value:"))
    a=1.8
    fahrenheit=(celcius1*a+32)
    print("the value is fahrenheit is", fahrenheit)
    
temp_fahrenheit()
     
def temp_fahrenheit(celcius1):
    celcius1=int(input("enter what is the value:"))
    a=1.8
    fahrenheit=(celcius1*a+32)
    print("the value is fahrenheit is", fahrenheit)
    
temp_fahrenheit()

def temp_celcius(fahrenheit1):
    fahrenheit1=int(input("enter what is the value:",+"C"))
    a=0.56
    celcius=(fahrenheit1*a-32)
    print("the value in celcius is", celcius,+"c")
    
temp_celcius()

def temperature_values(a,b,c,d,e,f):
    a=int(input("enter the temp1:"))
    b=int(input("enter the temp2:"))
    c=int(input("enter the temp3:"))
    d=int(input("enter the temp4:"))
    e=int(input("enter the temp5:"))
    f=int(input("enter the temp6:"))
    highest_num=max(a,b,c,d,e,f)
    lowest_num=min(a,b,c,d,e,f)
    mean=a+b+c+d+e+f/6
    print("the highest number is",highest_num, "the lowest number is", lowest_num, "the mean is",mean

temperature_values()











     
     