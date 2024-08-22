#include <iostream>
using namespace std;

//Uso de plantillas
template<typename T>
T suma_array(T arr[], int n) {
    T suma = 0;
    
    for(int i = 0; i < n; i++) {
        suma += arr[i];
    }
    
    return suma;
}

int main() {
    //Declaracion del arreglo.
    int arr[] = {1, 2, 3, 4, 5};
    
    cout << "Suma - Elementos: " << suma_array(arr, 5) << endl;
    return 0;
}
