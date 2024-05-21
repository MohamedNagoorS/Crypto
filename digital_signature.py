from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization
private_key = rsa.generate_private_key(
public_exponent=65537,
key_size=2048,
backend=default_backend()
)
pem = private_key.private_bytes(
encoding=serialization.Encoding.PEM,
format=serialization.PrivateFormat.PKCS8,
encryption_algorithm=serialization.NoEncryption()
)
print("Private Key in PEM Format:")
print(pem.decode())
public_key = private_key.public_key()
print("Key Details:")
print("Key size:", private_key.key_size)
print("Public Exponent:", private_key.public_numbers().e)
print("Modulus:", private_key.public_numbers().n)