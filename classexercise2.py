# -*- coding: utf-8 -*-
"""
Created on Mon Oct 17 13:46:18 2022

@author: HP EliteBook
"""

name= input("hello, what is your name?:")
print("hello", name,". Welcome to the program")

celcius_temperature=float(input("enter the temperature in celcius:"))
fahrenheit_temperature=(celcius_temperature)*1.8+32
print("the temperature  in fahrenheit is equivalent to",fahrenheit_temperature)

student_number=int(input("enter the number of students:"))
group_size=int(input("enter the group size:"))
each_group=student_number//group_size
left_over=student_number%group_size
print("there will be",each_group, "groups and", left_over,"students left")

candy=int(input("enter the number of candy:"))
students=int(input("enter the number of students:"))
each_pupil=candy//students
left_over=candy%students
print("give",each_pupil, "to each student, you will have",left_over,"candy left")

name= input("hello, what is your name?:")
if name:
  print("hello", name,". Welcome to the program")
else:
  print("hello stranger.Welcome to the program")
  
password_1=input("what is your password:")
password_2=input("what is your password:")
if password_1==password_2:
    print("Password Set")
else: 
    print("error in password")
    



