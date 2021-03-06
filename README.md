<h1>TextCut</h1>
Выделение из каждой строки текстового файла некоторой подстроки:
<li><b><i>file</i></b> задает имя входного файла. Если параметр отсутствует, считываются входные данные с консольного ввода;
<li>Флаг <i>-o</i> <b><i>ofile</i></b> задает имя выходного файла (в данном случае ofile). Если параметр отсутствует, результат выводится
на консольный вывод.
<li>Флаг <i>-c</i> означает, что все числовые параметры задают отступы в символах (буквах) входного файла.
<li>Флаг <i>-w</i> означает, что все числовые параметры задают отступы в словах (т.е. последовательностях символов без пробелов) входного файла.
<li>Параметр <b><i>range</i></b> задает выходной диапазон и имеет один из следующих видов (здесь N и K - целые числа):
<blockquote>	
<li><i>-K</i> диапазон от начала строки до <i>K</i>
<li><i>-N</i> диапазон от <i>N</i> до конца строки
<li><i>N-K</i> диапазон от <i>N</i> до <i>K</i>
</blockquote>	
Command line: cut [-c|-w] [-o <i>ofile</i>] [<i>file</i>] <i>range</i>

Программа построчно обрабатывает входные данные и для каждой строки выдает часть этой строки согласно заданному диапазону. Если
какого-то из указанных файлов не существует или неправильно указаны параметры -c и -w (должен быть указан ровно один из них), выдается
ошибка. Если в строке не хватает символов или слов, это ошибкой не является, в этом случае выдается та часть входных данных, 
которая попадает в диапазон.
