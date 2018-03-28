public static GoalDecider getLocationGoalDecider(final Location target) {
    return new GoalDecider() {

        private PathNode best = null;

        private int bestCost = FreeColObject.INFINITY;

        @Override
        public PathNode getGoal() {
            return best;
        }

        @Override
        public boolean hasSubGoals() {
            return false;
        }

        @Override
        public boolean check(Unit u, PathNode path) {
            int cost;
            if (Map.isSameLocation(path.getLocation(), target)) {
                if ((cost = path.getCost()) < bestCost) {
                    best = path;
                    bestCost = cost;
                }
                return true;
            }
            return false;
        }
    };
}