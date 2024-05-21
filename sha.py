import hashlib  
def hash_message(message):
    hash_obj = hashlib.sha1()
    hash_obj.update(message.encode())
    return hash_obj.hexdigest()
text = input("Enter Message: ")
print("The SHA-1 hash of the message is:", hash_message(text))
