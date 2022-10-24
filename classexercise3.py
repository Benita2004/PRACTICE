# -*- coding: utf-8 -*-
"""
Created on Mon Oct 17 13:44:54 2022

@author: HP EliteBook
"""

name= input("hello, what is your name?:")
if name =="":
   print("hello stranger.Welcome to the program")
else:
   print("hello", name,". Welcome to the program")
#%%
password_1=input("what is your password:")    
if len(password_1) < 8 and len(password_1) > 12:
    print("Password Set")
else: 
    print("error in password")

password_1=input("what is your password:")
password_2=input("what is your password:")
if password_1==password_2:
    print("Password Set")
else: 
    print("error in password")
    
password=input("what is your password:")
bad_password =['password','letmein','sesame','hello','justinbeiber']
if password in bad_password:
    print("bad password")
else:
    print("password is accurate")

#%%    
number=7
for i in range (0,13,1):
    print(number*i)

number=int(input("enter what is the number:"))
  for i in range (0,13,1):
      if number<=12:
      print(number*i)
    