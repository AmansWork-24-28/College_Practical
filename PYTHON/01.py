import pandas as pd

data = {
    "Date": ["11 Feb", "12 Feb", "13 Feb", "14 Feb"],
    "Temperature(°C)": [22, 21, 23, 40],
    "Humidity(%)": [50, 60, 55, 48]
}

weather_DF = pd.DataFrame(data)
print(weather_DF)
