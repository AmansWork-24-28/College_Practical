print("-----SIMPLE CALCULATOR-----")
print("Operators- +,-,/,*,%")

num1=int(input("enter the number 1: "))
num2=int(input("enter the number 2: "))
operator=input("tell me which operation to do- ")

if(operator== "+"):
    print(f"{num1}+{num2} = {num1 + num2} ")
elif(operator== "-"):
    print(f"{num1}-{num2} = {num1 - num2} ")
elif(operator== "*"):
    print(f"{num1}*{num2} = {num1 * num2} ")
elif(operator== "%"):
    print(f"{num1}%{num2} = {num1 % num2} ")
elif(operator== "/"):
    print(f"{num1}/{num2} = {num1 / num2} ")
else:
    print("ERROR")
