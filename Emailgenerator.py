# -*- coding: utf-8 -*-
"""
@author: HP EliteBook
"""

import re
import random
import logging

def generate_student_email(student_id, student_name):
    """Generate a unique student email address."""
    try:
        # Extract initials from the student's name
        initials = ".".join(name[0].lower() for name in student_name.split())

        # Extract surname for the email address
        surname = re.sub(r'[^a-zA-Z]', '', student_name.split()[-1].lower())

        # Generate a random 4-digit number for uniqueness
        random_digits = random.randint(1000, 9999)

        # Construct the student email address
        student_email = f"{student_id} {initials}.{surname}{random_digits}@poppleton.ac.uk"
        return student_email
    except Exception as e:
        logging.error(f"Error generating email for student ID {student_id}: {e}")
        return None

def main():
    """Main function to read student IDs and names, and write corresponding email addresses."""
    try:
        # Open the file containing student IDs and names
        with open("studentid_name.txt", "r") as student_file:
            students = student_file.readlines()

        # Open a new file to write student email addresses
        with open("studentmail.txt", "w") as studentmails:
            for student in students:
                # Split the line into ID and name
                student_info = student.strip().split(",")
                student_id, student_name = student_info[0], student_info[1].strip()
                
                # Generate student email
                student_email = generate_student_email(student_id, student_name)
                
                # Write the student email address to the file
                if student_email:
                    studentmails.write(student_email + "\n")
    except FileNotFoundError:
        logging.error("Input file not found.")
    except Exception as e:
        logging.error(f"An error occurred: {e}")

if __name__ == "__main__":
    # Configure logging
    logging.basicConfig(filename='automation.log', level=logging.ERROR)
    
    # Run the main function
    main()
    print("Task completed.")
