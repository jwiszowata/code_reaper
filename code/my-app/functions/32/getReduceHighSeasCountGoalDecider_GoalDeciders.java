public static GoalDecider getReduceHighSeasCountGoalDecider(final Unit unit) {
    return new GoalDecider() {

        private PathNode goal = null;

        private int score = unit.getTile().getHighSeasCount();

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
            if (tile.getHighSeasCount() < score) {
                Settlement s = tile.getSettlement();
                if (unit.getOwner().owns(s)) {
                    this.goal = pathNode;
                    this.score = tile.getHighSeasCount();
                    return true;
                }
            }
            return false;
        }
    };
}