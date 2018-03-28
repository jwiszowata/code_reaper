public static CostDecider getComposedCostDecider(final CostDecider... cds) {
    if (cds.length < 2) {
        throw new IllegalArgumentException("Short CostDecider list");
    }
    return new CostDecider() {

        private final CostDecider[] costDeciders = cds;

        private int ret = -1;

        private int index = -1;

        @Override
        public int getCost(Unit unit, Location oldLocation, Location newLocation, int movesLeft) {
            for (int i = 0; i < costDeciders.length; i++) {
                int cost = costDeciders[i].getCost(unit, oldLocation, newLocation, movesLeft);
                if (cost == ILLEGAL_MOVE || cost == Map.INFINITY) {
                    index = i;
                    return ILLEGAL_MOVE;
                }
                if (cost > ret) {
                    index = i;
                    ret = cost;
                }
            }
            return ret;
        }

        @Override
        public int getMovesLeft() {
            return (index < 0) ? 0 : costDeciders[index].getMovesLeft();
        }

        @Override
        public int getNewTurns() {
            return (index < 0) ? 0 : costDeciders[index].getNewTurns();
        }
    };
}