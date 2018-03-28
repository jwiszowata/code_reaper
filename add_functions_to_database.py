from code_reaper.models import Function
from os import listdir
from os.path import isfile, join
#import matplotlib.pyplot as plt
import numpy as np


def countSignsIdx(lines):
	lengths = [pow(len(line) - 1, 2) for line in lines]
	return round(sum(lengths) / 100)

def clean(arr, m):
	res = []
	for i in range(0, len(arr)):
		if i % m != 0:
			res += [arr[i]]
	return res

def divideOnLevels(funs, levels):
	x = np.zeros(levels + 1, dtype=int)
	s = np.zeros(levels + 1, dtype=int)
	l = np.zeros(funs, dtype=int)
	for i in range(1, levels + 1):
	    x[i] = round(0.31 * i * i - 12.4285 * i + 136)
	    s[i] = s[i-1] + x[i]
	    l[s[i-1]:s[i]] = i
	return l

def readFunsFromFile(minLines, maxLines, lvlNr, funsNr):
	ff = []
	dif = []
	idx = 0
	for i in range(minLines, maxLines + 1):
		path = "./code/my-app/functions/" + str(i)
		files = [f for f in listdir(path) if isfile(join(path, f))]

		for file in files:
			filename = file.split('.')[0]
			names = filename.split('_')
			with open(path + "/" + file) as body:
				bodyLines = body.readlines()
				difficulty = countSignsIdx(bodyLines)
				readBody = "".join(bodyLines)
				dif += [[difficulty, idx]]
				idx += 1
				ff += [Function(
						name=names[0], 
						project="FreeCol",
						class_name=names[1], 
						body=readBody, 
						lines_nr=i,
						#signs_nr=len(readBody),
						difficulty=difficulty)]
	return (dif, ff)

# def plotSth():
# 	t = np.arange(0.0, 1.0, 0.001)
# 	s = sorted(chosen_dif[0:1000])#1 + np.sin(2 * np.pi * t)

# 	# Note that using plt.subplots below is equivalent to using
# 	# fig = plt.figure and then ax = fig.add_subplot(111)
# 	fig, ax = plt.subplots()
# 	ax.plot(t, s)

# 	ax.set(xlabel='time (s)', ylabel='voltage (mV)',
# 	       title='About as simple as it gets, folks')
# 	ax.grid()

# 	fig.savefig("test.png")
# 	plt.show()

def setLevels(dif, funs, funsNr, lvlNr):
	sdif = sorted(dif, key=lambda x: x[0])
	clean_dif = clean(sdif, 2)
	levels = divideOnLevels(funsNr, lvlNr)
	fs = []
	for i in range(0, funsNr):
		idx = clean_dif[i][1]
		setattr(funs[idx], 'level', levels[i])
		fs += [funs[idx]]
	return fs

def createFunctions():
	funsNr = 1000
	lvlNr = 20
	(dif, f) = readFunsFromFile(6, 30, lvlNr, funsNr)
	fs = setLevels(dif, f, funsNr, lvlNr)
	print(len(fs))
	Function.objects.bulk_create(fs)

createFunctions()