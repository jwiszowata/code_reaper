from code_reaper.models import Function
from os import listdir
from os.path import isfile, join

for i in range(6, 30):
	path = "../../code/my-app/functions/" + str(i)
	files = [f for f in listdir(path) if isfile(join(path, f))]

	f = []
	for file in files:
		filename = file.split('.')[0]
		names = filename.split('_')
		with open(path + "/" + file) as body:
			read_body = body.read()
			f += [Function(name=names[0], class_name=names[1], body=read_body, lines_nr=i)]
	Function.objects.bulk_create(f)