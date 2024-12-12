INSERT INTO practice_topics (practice_topic_name, material) VALUES
-- Ветвления и Циклы
(
    'Ветвления и Циклы (Задача)',
    'Написать программу, которая выводит таблицу умножения на заданное число, используя цикл for.

#include <iostream>
using namespace std;

int main() {
    int number;
    cout << "Введите число для таблицы умножения: ";
    cin >> number;

    for (int i = 1; i <= 10; ++i) {
        cout << number << " x " << i << " = " << number * i << endl;
    }

    return 0;
}'
),
-- Ссылки
(
    'Ссылки (Задача)',
    'Написать функцию, которая принимает две переменные по ссылке и меняет их местами.

#include <iostream>
using namespace std;

void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

int main() {
    int x = 10, y = 20;
    cout << "До обмена: x = " << x << ", y = " << y << endl;

    swap(x, y);

    cout << "После обмена: x = " << x << ", y = " << y << endl;

    return 0;
}'
),
-- Указатели
(
    'Указатели (Задача)',
    'Создать программу, которая выделяет память для массива с использованием указателей и заполняет его числами от 1 до n.

#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Введите размер массива: ";
    cin >> n;

    int *arr = new int[n];

    for (int i = 0; i < n; ++i) {
        arr[i] = i + 1;
    }

    cout << "Содержимое массива: ";
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";
    }
    cout << endl;

    delete[] arr; // Освобождение памяти

    return 0;
}'
),
-- Константность
(
    'Константность (Задача)',
    'Создать программу, которая принимает массив по константной ссылке и выводит его элементы.

#include <iostream>
#include <vector>
using namespace std;

void printArray(const vector<int> &arr) {
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;
}

int main() {
    vector<int> numbers = {1, 2, 3, 4, 5};
    cout << "Содержимое массива: ";
    printArray(numbers);

    return 0;
}'
),
-- Функции в C++
(
    'Функции в C++ (Задача)',
    'Написать программу, которая включает функцию для вычисления факториала числа.

#include <iostream>
using namespace std;

int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

int main() {
    int number;
    cout << "Введите число: ";
    cin >> number;

    cout << "Факториал " << number << " = " << factorial(number) << endl;

    return 0;
}'
),
-- Шаблоны в C++
(
    'Шаблоны в C++ (Задача)',
    'Написать шаблонную функцию, которая возвращает большее из двух переданных значений.

#include <iostream>
using namespace std;

template<typename T>
T getMax(T a, T b) {
    return (a > b) ? a : b;
}

int main() {
    cout << "Максимум из 3 и 7: " << getMax(3, 7) << endl;
    cout << "Максимум из 5.5 и 2.3: " << getMax(5.5, 2.3) << endl;

    return 0;
}'
);