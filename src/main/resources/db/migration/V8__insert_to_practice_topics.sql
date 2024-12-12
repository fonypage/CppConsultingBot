INSERT INTO practice_topics (practice_topic_name, material) VALUES
('Типы данных(Задача)', ' Объявить переменные с помощью которых можно будет посчитать общую сумму покупки нескольких товаров. Например плитки шоколада, кофе и пакеты молока.

#include <iostream>
using namespace std;

int main()
{
 setlocale(LC_ALL, "rus");

 int chocolate = 2; // хранит количество упаковок
 int milk = 3;
 int coffee = 1;

 float priceOfChocolate = 11.04; // хранит цены за одну упаковку
 float priceOfMilk = 9.59;
 float priceOfCoffee = 70.77;

 float sum = 0;  // общая сумма покупки

 // считаем стоимость
 sum = (chocolate * priceOfChocolate) + (milk * priceOfMilk) + (coffee * priceOfCoffee);

 cout << "Общая стоимость покупки = "; // показываем расчет и общую стоимость на экран
 cout << chocolate * priceOfChocolate << "+" << milk * priceOfMilk << "+"" << coffee * priceOfCoffee;
 cout << " = " << sum << endl << endl;

 return 0;
}
');