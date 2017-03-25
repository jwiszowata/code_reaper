files=`find FreeCol -type f -name "*.java"`
for file in $files;
do
    echo $file
    mv $file "./FreeCol_files/"
done