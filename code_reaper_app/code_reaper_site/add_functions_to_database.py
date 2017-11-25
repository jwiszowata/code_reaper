from code_reaper.models import Function
from os import listdir
from os.path import isfile, join

N_min = 6
N_max = 30
S_max = 120

for i in range(N_min, N_max + 1):
	path = "../../code/my-app/functions/" + str(i)
	files = [f for f in listdir(path) if isfile(join(path, f))]

	f = []
	for file in files:
		filename = file.split('.')[0]
		names = filename.split('_')
		with open(path + "/" + file) as body:
			read_body = body.read()
			signs = len(read_body)
			per_line = signs / i
			line_idx = (i - N_min) * S_max / (N_max - N_min)
			difficulty = round((line_idx * line_idx + per_line * per_line) / 100)
			f += [Function(
				name=names[0], 
				project="FreeCol",
				class_name=names[1], 
				body=read_body, 
				lines_nr=i, 
				signs_nr=signs, 
				difficulty=difficulty)]
	Function.objects.bulk_create(f)