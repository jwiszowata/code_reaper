number=$1
dir=$2
mkdir $dir
for i in {3..20}
do
    mkdir ./$dir/$i
    shuf -n $number -e ./functions/$i/* | xargs -i mv {} ./$dir/$i/
done