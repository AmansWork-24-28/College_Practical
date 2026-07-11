string = input("Enter the string to be checked: ")
reverse = " "

for i in string:
    reverse = i + reverse 

print(reverse)

if(string==reverse):
    print("IT'S A PALINDROME")
elif(string!=reverse):
    print("NOT A PALINDROME")
