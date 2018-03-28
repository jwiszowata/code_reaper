public static GoalDecider getComposedGoalDecider(final boolean all, final GoalDecider... gds) {
    if (gds.length < 2) {
        throw new IllegalArgumentException("Short GoalDecider list");
    }
    return new GoalDecider() {

        private int winner = gds.length;

        private PathNode goal = null;

        @Override
        public PathNode getGoal() {
            return goal;
        }

        @Override
        public boolean hasSubGoals() {
            for (int i = 0; i < gds.length; i++) {
                if (!all && i > this.winner)
                    break;
                if (gds[i].hasSubGoals()) {
                    if (!all)
                        return true;
                } else {
                    if (all)
                        return false;
                }
            }
            return !all;
        }

        @Override
        public boolean check(Unit u, PathNode path) {
            for (int i = 0; i < gds.length; i++) {
                if (!all && i > this.winner)
                    break;
                if (gds[i].check(u, path)) {
                    if (!all) {
                        this.winner = i;
                        this.goal = path;
                        return true;
                    }
                } else {
                    if (all) {
                        return false;
                    }
                }
            }
            if (all) {
                this.winner = 0;
                this.goal = path;
                return true;
            }
            return false;
        }
    };
}