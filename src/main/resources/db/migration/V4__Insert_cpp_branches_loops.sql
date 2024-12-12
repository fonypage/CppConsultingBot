-- V3__Insert_cpp_branches_loops.sql

INSERT INTO theory_topics (topic_name, material) VALUES
(
    'Ветвления и Циклы',
    CONCAT(
        'В языке программирования C++ существует несколько конструкций для управления потоком выполнения программы. Основными из них являются ветвления и циклы.\n\n',

        'Ветвления\n\n',

        'if\n',
        'Позволяет выполнять определённый блок кода, если условие истинно.\n',
        'Синтаксис:\n',
        'if (условие) {\n',
        '    // код, выполняемый при истинном условии\n',
        '}\n\n',

        'if-else\n',
        'Позволяет выполнять один блок кода, если условие истинно, и другой — если ложно.\n',
        'Синтаксис:\n',
        'if (условие) {\n',
        '    // код, выполняемый при истинном условии\n',
        '} else {\n',
        '    // код, выполняемый при ложном условии\n',
        '}\n\n',

        'else if\n',
        'Позволяет проверить несколько условий последовательно.\n',
        'Синтаксис:\n',
        'if (условие1) {\n',
        '    // код при истинном условии1\n',
        '} else if (условие2) {\n',
        '    // код при истинном условии2\n',
        '} else {\n',
        '    // код, выполняемый если все условия ложны\n',
        '}\n\n',

        'switch\n',
        'Позволяет выполнять различные блоки кода в зависимости от значения переменной.\n',
        'Синтаксис:\n',
        'switch (выражение) {\n',
        '    case значение1:\n',
        '        // код для значения1\n',
        '        break;\n',
        '    case значение2:\n',
        '        // код для значения2\n',
        '        break;\n',
        '    default:\n',
        '        // код по умолчанию\n',
        '}\n\n',

        'Циклы\n\n',

        'for\n',
        'Позволяет выполнять блок кода определённое количество раз.\n',
        'Синтаксис:\n',
        'for (инициализация; условие; итерация) {\n',
        '    // код, выполняемый в цикле\n',
        '}\n\n',

        'while\n',
        'Выполняет блок кода, пока условие истинно.\n',
        'Синтаксис:\n',
        'while (условие) {\n',
        '    // код, выполняемый в цикле\n',
        '}\n\n',

        'do-while\n',
        'Выполняет блок кода хотя бы один раз, а затем повторяет выполнение, пока условие истинно.\n',
        'Синтаксис:\n',
        'do {\n',
        '    // код, выполняемый в цикле\n',
        '} while (условие);\n\n',

        'break\n',
        'Прерывает выполнение цикла или оператора switch.\n\n',

        'continue\n',
        'Пропускает оставшуюся часть кода в текущей итерации цикла и переходит к следующей.\n\n',

        'goto\n',
        'Позволяет перейти к определённой метке в коде. Использование goto не рекомендуется, так как может привести к трудноотслеживаемым ошибкам.\n'
    )
);
