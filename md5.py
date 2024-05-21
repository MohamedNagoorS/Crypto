import hashlib
def hash_message(message):
    hash_obj = hashlib.md5()
    hash_obj.update(message.encode())
    return hash_obj.hexdigest()
user_input = input("ENTER MESSAGE: ")
hashed_output = hash_message(user_input)
print("The hexadecimal equivalent of hash is:", hashed_output)