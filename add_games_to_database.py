from code_reaper.models import Game
import random

games = []
random.seed(a=2034)

for i in range(1,17):
	random_nr = random.randrange(start=1287, stop=9853, step=1)
	games += [Game(number=i, seed=random_nr)]

Game.objects.bulk_create(games)