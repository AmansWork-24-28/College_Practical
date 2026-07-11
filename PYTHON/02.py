print("----TRAVEL WITH THE MOOD----")
print("")

temp = int(input("Enter the temperature: "))

if (temp < 0):
    if (-5 <= temp <= 0):
        print("Let's go to Kashmir")
    elif (-10 <= temp < -5):
        print("Let's go to Ladakh")
elif (temp > 0):
    if (0 <= temp < 10):
        print("Let's go to Assam")
    elif (10 <= temp < 15):
        print("Let's go to Chandigarh")
    elif (15 <= temp < 20):
        print("Let's go to Delhi")
    elif (20 <= temp < 25):
        print("Let's go to Bihar")
    elif (25 <= temp < 30):
        print("Let's go to Jharkhand")
    elif (30 <= temp < 35):
        print("Let's go to Maharashtra")
    elif (35 <= temp < 40):
        print("Let's go to Gujarat")
    elif (40 <= temp <= 50):
        print("Let's go to Rajasthan")
else:
    print("GHAR PE BAITHO !!")
