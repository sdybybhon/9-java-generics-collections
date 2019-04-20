# Задание 03 Анаграммы

Реализуйте алгоритм поиска анаграмм в заданном словаре. 

Метод findAnagrams принимает слова, разделенные разрывом строки, в виде InputStream.

На выходе должен получиться список, состоящий из наборов слов, каждое из которых является анаграммой других слов в наборе.

- все слова должны быть приведены в нижний регистр
- каждый набор должен состоять минимум из 2 слов
- слова в каждом наборе должны быть отсортированы в алфавитном порядке.
- наборы в списке должны быть отсортированы по первым словам в наборах, в алфавитном порядке.

Алгоритм должен учитывать следующие возможные ошибки во входных данных:

- Исключать слова, содержащие меньше 3 символов.
- Исключать слова, содержащие символы, отличные от русских букв.
- Учитывать повторяющиеся слова только 1 раз.

### Пример входных данных
```
трос
накал
рост
чесотка
сорт
отсечка
```

### Результат
```
[отсечка, чесотка]
[рост, сорт, трос]
```