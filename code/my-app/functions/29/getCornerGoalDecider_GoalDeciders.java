public static GoalDecider getCornerGoalDecider() {
    return new GoalDecider() {

        private PathNode goal = null;

        private int score = Integer.MAX_VALUE;

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
            if (tile.getHighSeasCount() < score && tile.isRiverCorner()) {
                score = tile.getHighSeasCount();
                goal = pathNode;
                return true;
            }
            return false;
        }
    };
}