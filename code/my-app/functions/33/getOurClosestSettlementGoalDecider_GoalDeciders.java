public static GoalDecider getOurClosestSettlementGoalDecider() {
    return new GoalDecider() {

        private PathNode bestPath = null;

        private float bestValue = 0.0f;

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
            Location loc = path.getLastNode().getLocation();
            Settlement settlement = loc.getSettlement();
            if (settlement != null && settlement.getOwner().owns(u)) {
                float value = ((settlement.isConnectedPort()) ? 2.0f : 1.0f) / (path.getTotalTurns() + 1);
                if (bestValue < value) {
                    bestValue = value;
                    bestPath = path;
                    return true;
                }
            }
            return false;
        }
    };
}