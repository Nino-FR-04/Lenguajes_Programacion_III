def suma_array(lista):
    suma = 0
    for i in lista:
        suma += i
    return suma

def main():
    print(f"Suma - Elementos: {suma_array(list(range(1,6)))}")

main()