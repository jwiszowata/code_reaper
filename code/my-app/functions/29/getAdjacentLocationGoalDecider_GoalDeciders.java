public static GoalDecider getAdjacentLocationGoalDecider(Location target) {
    final Tile tile = target.getTile();
    if (tile == null)
        return null;
    return new GoalDecider() {

        private PathNode best = null;

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
            Tile t = path.getTile();
            if (t != null && t.isAdjacent(tile)) {
                best = path;
                return true;
            }
            return false;
        }
    };
}