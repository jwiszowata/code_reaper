public void csNewTurn(Random random, LogBuilder lb, ChangeSet cs) {
    logger.finest("ServerEurope.csNewTurn, for " + this);
    for (Unit unit : transform(getUnits(), u -> u.isNaval() && u.isDamaged())) {
        ((ServerUnit) unit).csRepairUnit(cs);
    }
}