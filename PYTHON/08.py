import yfinance as yf
import matplotlib.pyplot as plt
St_data = yf.download('nestleind.NS', start='2022-01-01' , end='2023-01-01')
print(St_data)
plt.plot(St_data['Close'],label='closing price')
plt.title('Nestle ind stock price')
plt.xlabel('date')
plt.ylabel('Price(INR)')
plt.legend()
plt.show()
