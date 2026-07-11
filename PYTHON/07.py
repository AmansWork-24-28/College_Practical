import yfinance as yf
import matplotlib.pyplot as plt
St_data = yf.download('GOOGL', start='2022-01-01' , end='2024-01-01')
print(St_data)
plt.plot(St_data['Close'],label='closing price')
plt.title('Google stock price')
plt.xlabel('date')
plt.ylabel('Price(USD)')
plt.legend()
plt.show()
