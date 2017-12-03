from code_reaper.models import Function
from os import listdir
from os.path import isfile, join

N_min = 6
N_max = 30

for i in range(N_min, N_max + 1):
	path = "../../code/my-app/functions/" + str(i)
	files = [f for f in listdir(path) if isfile(join(path, f))]

	f = []
	for file in files:
		filename = file.split('.')[0]
		names = filename.split('_')
		with open(path + "/" + file) as body:
			read_body = body.read()
			signs_idx = count_signs_idx(body)
			lines_idx = count_lines_idx(i)
			difficulty = round((pow(lines_idx, 2) + pow(signs_idx, 2)) / 100)
			f += [Function(
				name=names[0], 
				project="FreeCol",
				class_name=names[1], 
				body=read_body, 
				lines_nr=i, 
				signs_nr=signs, 
				difficulty=difficulty)]
	Function.objects.bulk_create(f)

def count_signs_idx(body):
	lines = body.split('\n')
	lengths = [len(line) * len(line) for line in lines]
	return round(sum(lengths) / (len(lines) * 100))

def count_lines_idx(lines_nr):
	signs_idx_max = 144
	shifted_lines_nr = lines_nr - N_min
	shifted_N_max = N_max - N_min
	return shifted_lines_nr * (signs_idx_max / shifted_N_max)
