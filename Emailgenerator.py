# -*- coding: utf-8 -*-
"""
Generates student email addresses from a list of student IDs and names.
"""

import re
import random
import logging

def generate_student_email(student_id, student_name):
    """Generate a unique student email address."""
    try:
        # Get initials and surname
        initials = "".join(name[0].lower() for name in student_name.split()[:-1])
        surname = re.sub(r'[^a-zA-Z]', '', student_name.split()[-1].lower())

        # Add random digits for uniqueness
        random_digits = random.randint(100, 999)

        # Construct email address
        student_email = f"{student_id}.{initials}{surname}{random_digits}@poppleton.ac.uk"
        return student_email

    except Exception as e:
        logging.error(f"Error generating email for {student_id}: {e}")
        return None


def main():
    """Main program to generate emails from student data."""
    try:
        with open("studentid_name.txt", "r") as student_file:
            students = student_file.readlines()

        with open("studentmail.txt", "w") as studentmails:
            for student in students:
                student_info = student.strip().split(",")
                if len(student_info) < 2:
                    logging.warning(f"Skipped invalid line: {student.strip()}")
                    continue

                student_id, student_name = student_info[0].strip(), student_info[1].strip()
                email = generate_student_email(student_id, student_name)

                if email:
                    studentmails.write(email + "\n")

        print("Task completed. Emails successfully generated.")

    except FileNotFoundError:
        logging.error("Input file not found.")
        print("The input file 'studentid_name.txt' was not found.")
    except Exception as e:
        logging.error(f"An error occurred: {e}")
        print("Something went wrong. Please check the log file.")


if __name__ == "__main__":
    logging.basicConfig(filename="automation.log", level=logging.ERROR)
    main()
