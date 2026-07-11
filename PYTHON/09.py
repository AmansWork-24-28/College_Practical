print("Hi! I'm ChatBuddy. Type 'bye' to exit.")

while True:
    input = input("You: ").lower()

    if input == "bye":
        print("ChatBuddy: Goodbye! Have a great day!")
        break

    elif "hello" in input or "hi" in input:
        print("ChatBuddy: Hello there! How can I help you?")

    elif "how are you" in input:
        print("ChatBuddy: I'm just a bunch of code, but I'm doing great!")

    elif "your name" in input:
        print("ChatBuddy: I'm ChatBuddy, your simple Python chatbot!")

    elif "help" in input:
        print("ChatBuddy: I'm here to talk. Try saying 'hi', 'how are you', or ask my name!")

    else:
        print("ChatBuddy: Sorry, I don't understand that. Try asking something else!")
