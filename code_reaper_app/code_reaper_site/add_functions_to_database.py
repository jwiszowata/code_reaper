from code_reaper.models import Function
from os import listdir
from os.path import isfile, join

for i in range(1, 30):
	path = "../../code/my-app/functions/" + str(i)
	files = [f for f in listdir(path) if isfile(join(path, f))]

	for file in files:
		filename = file.split('.')[0]
		names = filename.split('_')
		#print(names)
		with open(path + "/" + file) as body:
			read_body = body.read()
			#print(read_body)
			f = Function(name=names[0], class_name=names[1], body=read_body, lines_nr=i);
			f.save();
