import random

def get_password_number():
    """Prompt user to enter the number of passwords."""
    while True:
        try:
            password_number = int(input("Enter how many passwords you want: "))
            if 1 <= password_number <= 24:
                return password_number
            else:
                print("Please enter a number between 1 and 24.")
        except ValueError:
            print("Please enter a valid number.")

def generate_password():
    """Generate a random password."""
    CONSTANTS1 = ["vera", "benita", "valerie", "aalo", "innocent", "vanessa", "ahmed"]
    CONSTANTS2 = ["A@", "B#", "D*", "S$", "Kb", "Vg", "C&"]
    CONSTANTS3 = ["ala", "july", "august", "val", "liana", "june", "march", "may"]
    
    password = ''.join([
        random.choice(CONSTANTS1),
        random.choice(CONSTANTS2),
        random.choice(CONSTANTS3)
    ])
    return password

def main():
    """Generate and print the specified number of passwords."""
    password_number = get_password_number()
    for _ in range(password_number):
        password = generate_password()
        print(password)

if __name__ == "__main__":
    main()
