public static GoalDecider getEnemySettlementGoalDecider(final Collection<Player> enemies) {
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
            if (t == null || !t.isLand())
                return false;
            Settlement s = t.getSettlement();
            if (s == null)
                return false;
            if (enemies.contains(s.getOwner())) {
                best = path;
                return true;
            }
            return false;
        }
    };
}