## Итоговая контрольная работа
### Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.
### Задание
1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).
2. Создать директорию, переместить файл туда.
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.
4. Установить и удалить deb-пакет с помощью dpkg.
5. Выложить историю команд в терминале ubuntu
6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).
7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”
8. Создать таблицы с иерархией из диаграммы в БД
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
13.Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:
14.1 Завести новое животное
14.2 определять животное в правильный класс
14.3 увидеть список команд, которое выполняет животное
14.4 обучить животное новым командам
14.5 Реализовать навигацию по меню
15.Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
значение внутренней̆int переменной̆на 1 при нажатие “Завести новое
животное” Сделайте так, чтобы с объектом такого типа можно было работать в
блоке try-with-resources. Нужно бросить исключение, если работа с объектом
типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
считать в ресурсе try, если при заведения животного заполнены все поля.

## Решение
### Решение по пунктам с 1 по 5 представлены в папке task 1-5
<img width="747" height="673" alt="image" src="https://github.com/user-attachments/assets/4dfde904-56f2-4778-96f8-2f0fe4307ca8" />
<img width="659" height="584" alt="image" src="https://github.com/user-attachments/assets/0d53ef2b-cc97-4508-9d45-4f7a5d3d44ee" />
### Решение по пунктам с 6 по 13 представлены в папке task 6-13

```
DROP
database IF EXISTS HumanFriends;
CREATE
database HumanFriends;
USE
HumanFriends;

-- Создание таблиц
DROP TABLE IF EXISTS HumanFriends;
CREATE TABLE HumanFriends
(
    id_human_friend   INT AUTO_INCREMENT PRIMARY KEY,
    type_human_friend VARCHAR(255)
);

DROP TABLE IF EXISTS Pets;
CREATE TABLE Pets
(
    id_pet          INT AUTO_INCREMENT PRIMARY KEY,
    type_pet        VARCHAR(255),
    id_human_friend INT,
    FOREIGN KEY (id_human_friend) REFERENCES HumanFriends (id_human_friend)
);

DROP TABLE IF EXISTS PackAnimals;
CREATE TABLE PackAnimals
(
    id_pack_animal   INT AUTO_INCREMENT PRIMARY KEY,
    type_pack_animal VARCHAR(255),
    id_human_friend  INT,
    FOREIGN KEY (id_human_friend) REFERENCES HumanFriends (id_human_friend)
);

DROP TABLE IF EXISTS Cats;
CREATE TABLE Cats
(
    id_cat    INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255),
    birth_day DATE,
    commands  TEXT,
    id_pet    INT,
    FOREIGN KEY (id_pet) REFERENCES Pets (id_pet)
);

DROP TABLE IF EXISTS Dogs;
CREATE TABLE Dogs
(
    id_dog    INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255),
    birth_day DATE,
    commands  TEXT,
    id_pet    INT,
    FOREIGN KEY (id_pet) REFERENCES Pets (id_pet)
);

DROP TABLE IF EXISTS Hamsters;
CREATE TABLE Hamsters
(
    id_hamster INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255),
    birth_day  DATE,
    commands   TEXT,
    id_pet     INT,
    FOREIGN KEY (id_pet) REFERENCES Pets (id_pet)
);

DROP TABLE IF EXISTS Horses;
CREATE TABLE Horses
(
    id_horse       INT AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(255),
    birth_day      DATE,
    commands       TEXT,
    id_pack_animal INT,
    FOREIGN KEY (id_pack_animal) REFERENCES PackAnimals (id_pack_animal)
);

DROP TABLE IF EXISTS Camels;
CREATE TABLE Camels
(
    id_camel       INT AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(255),
    birth_day      DATE,
    commands       TEXT,
    id_pack_animal INT,
    FOREIGN KEY (id_pack_animal) REFERENCES PackAnimals (id_pack_animal)
);

DROP TABLE IF EXISTS Donkeys;
CREATE TABLE Donkeys
(
    id_donkey      INT AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(255),
    birth_day      DATE,
    commands       TEXT,
    id_pack_animal INT,
    FOREIGN KEY (id_pack_animal) REFERENCES PackAnimals (id_pack_animal)
);

-- Заполнение таблиц данными
INSERT INTO HumanFriends (type_human_friend)
VALUES ('Pet'),
       ('PackAnimal');
INSERT INTO Pets (type_pet, id_human_friend)
VALUES ('Cat', 1),
       ('Dog', 1),
       ('Hamster', 1);
INSERT INTO PackAnimals (type_pack_animal, id_human_friend)
VALUES ('Horse', 2),
       ('Camel', 2),
       ('Donkey', 2);
INSERT INTO Cats (name, birth_day, commands, id_pet)
VALUES ('Whiskers', '2022-01-01', 'sit, jump', 1);
INSERT INTO Dogs (name, birth_day, commands, id_pet)
VALUES ('Rex', '2021-05-10', 'fetch, sit', 2);
INSERT INTO Hamsters (name, birth_day, commands, id_pet)
VALUES ('Nibbles', '2023-03-20', 'run', 3);
INSERT INTO Horses (name, birth_day, commands, id_pack_animal)
VALUES ('Thunder', '2019-07-15', 'run', 1);
INSERT INTO Camels (name, birth_day, commands, id_pack_animal)
VALUES ('Sandy', '2020-10-30', 'carry', 2);
INSERT INTO Donkeys (name, birth_day, commands, id_pack_animal)
VALUES ('Eeyore', '2022-02-14', 'carry', 3);

SELECT *
FROM HumanFriends;
SELECT *
FROM Pets;
SELECT *
FROM PackAnimals;
SELECT *
FROM Cats;
SELECT *
FROM Dogs;
SELECT *
FROM Hamsters;
SELECT *
FROM Horses;
SELECT *
FROM Camels;
SELECT *
FROM Donkeys;

-- Удаление записей о верблюдах
DELETE
FROM Camels;
SELECT *
FROM Camels;

-- Объединение таблиц лошадей и ослов
DROP TABLE IF EXISTS HorsesAndDonkeys;
CREATE TABLE HorsesAndDonkeys AS
SELECT id_horse AS id, name, birth_day, commands, 'Horse' AS type
FROM Horses
UNION
SELECT id_donkey AS id, name, birth_day, commands, 'Donkey' AS type
FROM Donkeys;

SELECT *
FROM HorsesAndDonkeys;

-- Создание новой таблицы для животных в возрасте от 1 до 3 лет (от 12 до 36 месяцев)
DROP TABLE IF EXISTS YoungAnimals;
CREATE TABLE YoungAnimals AS
SELECT id,
       name,
       birth_day,
       commands,
       type,
       TIMESTAMPDIFF(MONTH, birth_day, CURDATE()) AS age_in_months
FROM (SELECT id_cat AS id, name, birth_day, commands, 'Cat' AS type
      FROM Cats
      UNION ALL
      SELECT id_dog AS id, name, birth_day, commands, 'Dog' AS type
      FROM Dogs
      UNION ALL
      SELECT id_hamster AS id, name, birth_day, commands, 'Hamster' AS type
      FROM Hamsters
      UNION ALL
      SELECT id AS id, name, birth_day, commands, type
      FROM HorsesAndDonkeys) AS AllAnimals
WHERE TIMESTAMPDIFF(MONTH, birth_day, CURDATE()) BETWEEN 12 AND 36;

SELECT *
FROM YoungAnimals;

-- Объединение всех созданных таблиц в одну
DROP TABLE IF EXISTS AllAnimals;
CREATE TABLE AllAnimals AS
SELECT id_cat AS id, name, birth_day, commands, 'Cat' AS type
FROM Cats
UNION
SELECT id_dog AS id, name, birth_day, commands, 'Dog' AS type
FROM Dogs
UNION
SELECT id_hamster AS id, name, birth_day, commands, 'Hamster' AS type
FROM Hamsters
UNION
SELECT id AS id, name, birth_day, commands, type
FROM HorsesAndDonkeys
UNION
SELECT id AS id, name, birth_day, commands, type
FROM YoungAnimals;

SELECT *
FROM AllAnimals;
```

Диаграмма классов:
<img width="978" height="546" alt="image" src="https://github.com/user-attachments/assets/565b114a-cc18-4408-818f-465dcb76ac79" />

