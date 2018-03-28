private static GoalDecider getGoalDecider(final AIUnit aiUnit, boolean deferOK) {
    return new GoalDecider() {

        private PathNode bestPath = null;

        private int bestValue = Integer.MIN_VALUE;

        @Override
        public PathNode getGoal() {
            return bestPath;
        }

        @Override
        public boolean hasSubGoals() {
            return true;
        }

        @Override
        public boolean check(Unit u, PathNode path) {
            int value = scorePath(aiUnit, path);
            if (bestValue < value) {
                bestValue = value;
                bestPath = path;
                return true;
            }
            return false;
        }
    };
}