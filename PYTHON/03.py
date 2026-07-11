a = int(input("enter first no. : "))
b = int(input("enter second no. : "))
c = int(input("enter third no. : "))

if(a>b and a>c ):
    print(f"{a} is the greatest .")
elif(b>a and b>c):
     print(f"{b} is the greatest .")
elif(c>a and c>b):
     print(f"{c} is the greatest .")
else:
    print("Error")
