a=0
for file in ../../FreeCol_files/*;
do
    if [ $((a%5)) -eq 0 ]
    then
        files1=$files1" "$file
    fi
    if [ $((a%5)) -eq 1 ]
    then
        files2=$files2" "$file
    fi
    if [ $((a%5)) -eq 2 ]
    then
        files3=$files3" "$file
    fi
    if [ $((a%5)) -eq 3 ]
    then
        files4=$files4" "$file
    fi
    if [ $((a%5)) -eq 4 ]
    then
        files5=$files5" "$file
    fi
    a=$a+1
done
#echo $files1
#echo $files2
#echo $files5
mvn exec:java -Dexec.args="$files1"
mvn exec:java -Dexec.args="$files2"
mvn exec:java -Dexec.args="$files3"
mvn exec:java -Dexec.args="$files4"
mvn exec:java -Dexec.args="$files5"