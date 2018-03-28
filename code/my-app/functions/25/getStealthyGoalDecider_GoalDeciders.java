public static GoalDecider getStealthyGoalDecider(final Player enemy) {
    return new GoalDecider() {

        private PathNode goal = null;

        @Override
        public PathNode getGoal() {
            return goal;
        }

        @Override
        public boolean hasSubGoals() {
            return true;
        }

        @Override
        public boolean check(Unit u, PathNode pathNode) {
            Tile tile = pathNode.getTile();
            if (enemy.canSee(tile))
                return false;
            this.goal = pathNode;
            return true;
        }
    };
}