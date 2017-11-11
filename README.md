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
copy_java_files.sh
------------------
bierze projekt i wybiera z niego pliki z rozszerzeniem .java i kopiuje je do folderu proejkt_files

split_on_functions.sh 
---------------------
dzieli wszystkie pliki z projektu na 5 zbiorów, na których następnie odpala funkcję wydzielającą funkcje i zapisującą je w osobnych plikach na ścieżce ./functions/liczba_lini_w_funkcji/plik

choose_random.sh 
----------------
_ile_plików_ _do_jakiego_folderu_ : dla każdej liczby _i_ z przedziału 3..20 tworzy folder _do_jakiego_folderu_/_i_ i zapisuje w nim _ile_plików_ wylosowanych spośród funkcji w foderze ./functions/_i_; _i_ oznacza liczbę linijek w funkcji

Colors:
SCREEN: #c5c1c0
STEEL: #0a1612
DENIM: #1a2930
MARIGOLD: #f7ce3e