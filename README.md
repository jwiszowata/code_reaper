Code Reaper Project

tego używam:
https://maven.apache.org/
https://github.com/javaparser

komendy:
cd /home/asia/Publiczny/studia/IVrok/MGR/code_reaper/code/my-app
mvn package - buduje
mvn exec:java - uruchamia
mvn exec:java -Dexec.args="arg1 arg2" - tak przekazzuje się argumenty

https://github.com/fenyo1/FreeCol

Jakie funkcje są dobre?
Nie testowe

Gra
Rumcajs
Usosowa królowa
Podpięciowy faszysta

może warto dodać przycisk nie rozumiem co robi dana funkcja

wykaz skryptów:
===============
=> split_on_functions.sh : dzieli wszystkie pliki z projektu na 5 zbiorów, na których następnie odpala funkcję wydzielającą funkcje i zapisującą je w osobnych plikach na ścieżce ./functions/<liczba lini w funkcji>/<plik>
=> choose_random.sh <ile plików> <do jakiego folderu> : dla każdej liczby <i> z przedziału 3..20 tworzy folder <do jakiego folderu>/<i> i zapisuje w nim <ile plików> wylosowanych spośród funkcji w foderze ./functions/<i>; <i> oznacza liczbę linijek w funkcji
