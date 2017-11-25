from os import listdir
from os.path import isfile, join

for i in range(6, 31):
	path = "../../code/my-app/functions/" + str(i)
	files = [f for f in listdir(path) if isfile(join(path, f))]

	f = []
	for file in files:
		with open(path + "/" + file) as body:
			read_body = body.read()
			tokens = read_body.split("\n")
			for line in tokens:
				assert (len(line) <= 120), str(i) +": Line longer than 120 (" + str(len(line)) + ") in file " + file + " " + line
	print("ok " + str(i));