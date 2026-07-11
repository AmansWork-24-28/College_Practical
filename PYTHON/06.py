print("----------WELCOME TO FOODIES----------")

import pandas as pd

DICT = {
    "Category": ["Spicy", "Spicy", "Spicy", "Spicy", "Spicy",
                 "Sweet", "Sweet", "Sweet", "Sweet", "Sweet",
                 "Fried", "Fried", "Fried", "Fried", "Fried"],
    "Item": ["Phaal Curry", "Chili Chicken", "Paneer Masala", "Chicken Handi", "Chicken Changezi",
             "Gulab Jamun", "Rasmalai", "Pastry", "Burfi", "Basundi",
             "Samosa", "Pakodi", "Vada Pav", "Bread Pakoda", "Chole Bhature"],
    "Price": [150, 160, 270, 180, 160,
              50, 60, 70, 80, 100,
              20, 30, 10, 20, 120]
}

menu_card = pd.DataFrame(DICT)

print(menu_card)
