INSERT INTO theory_topics (topic_name, material) VALUES
(
    'Шаблоны в C++',
    CONCAT(
        'Шаблоны в языке программирования C++ позволяют писать универсальный и многократно используемый код, который работает с разными типами данных. Это очень мощный инструмент, позволяющий создавать типобезопасные и обобщенные функции и классы.\n\n',

        'Шаблоны\n\n',
        'Шаблоны используются для написания кода, который может работать с различными типами данных. Вместо того чтобы дублировать функции или классы для работы с разными типами, можно использовать шаблоны, что повышает гибкость и уменьшает объем кода.\n',

        'Шаблонная функция:\n',
        'template<typename T>\n',
        'T add(T a, T b) {\n',
        '    return a + b;\n',
        '}\n\n',

        'Шаблонные функции\n\n',
        'Шаблонные функции позволяют определять функции, которые могут работать с различными типами данных. При вызове такой функции компилятор автоматически создает нужную версию функции для переданного типа.\n',
        'Пример:\n',
        'template<typename T>\n',
        'T multiply(T a, T b) {\n',
        '    return a * b;\n',
        '}\n\n',
        'int main() {\n',
        '    std::cout << multiply(3, 4) << std::endl; // Результат: 12\n',
        '    std::cout << multiply(3.5, 2.0) << std::endl; // Результат: 7.0\n',
        '}\n\n',

        'Вывод шаблонных параметров\n\n',
        'При вызове шаблонной функции компилятор может автоматически вывести тип параметра из аргументов, которые переданы в функцию. Это позволяет использовать шаблоны без явного указания типа.\n',
        'Пример:\n',
        'template<typename T>\n',
        'void printValue(T value) {\n',
        '    std::cout << value << std::endl;\n',
        '}\n\n',
        'int main() {\n',
        '    printValue(10); // Тип T выводится как int\n',
        '    printValue(\"Hello\"); // Тип T выводится как const char*\n',
        '}\n\n',

        'Перегрузка шаблонных функций\n\n',
        'Шаблонные функции могут быть перегружены, как и обычные функции. Можно создать несколько шаблонов, которые принимают разные типы данных или разное количество параметров.\n',
        'Пример:\n',
        'template<typename T>\n',
        'T add(T a, T b) {\n',
        '    return a + b;\n',
        '}\n\n',
        'template<typename T>\n',
        'T add(T a, T b, T c) {\n',
        '    return a + b + c;\n',
        '}\n\n',
        'int main() {\n',
        '    std::cout << add(3, 4) << std::endl; // Вызывает функцию с 2 параметрами\n',
        '    std::cout << add(1, 2, 3) << std::endl; // Вызывает функцию с 3 параметрами\n',
        '}\n\n',

        'Шаблонные классы\n\n',
        'Шаблоны могут использоваться не только для функций, но и для классов. Это позволяет создавать универсальные классы, которые могут работать с разными типами данных.\n',
        'Пример шаблонного класса:\n',
        'template<typename T>\n',
        'class Box {\n',
        'private:\n',
        '    T value;\n',
        'public:\n',
        '    Box(T val) : value(val) {}\n',
        '    T getValue() {\n',
        '        return value;\n',
        '    }\n',
        '};\n\n',
        'int main() {\n',
        '    Box<int> intBox(123);\n',
        '    Box<std::string> strBox(\"Hello\");\n',
        '    std::cout << intBox.getValue() << std::endl; // Результат: 123\n',
        '    std::cout << strBox.getValue() << std::endl; // Результат: Hello\n',
        '}\n'
    )
);
