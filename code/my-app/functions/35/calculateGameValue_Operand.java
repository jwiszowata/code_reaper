private Integer calculateGameValue(Game game) {
    final String methodName = getMethodName();
    int result = 0;
    switch(this.operandType) {
        case NONE:
            result = game.invokeMethod(methodName, Integer.class, 0);
            break;
        case YEAR:
            result = game.getTurn().getYear();
            break;
        case OPTION:
            result = game.getSpecification().getInteger(getType());
            break;
        default:
            for (Player player : game.getLivePlayerList()) {
                switch(this.operandType) {
                    case UNITS:
                        result += ourCount(player.getUnitList());
                        break;
                    case BUILDINGS:
                        result += sum(player.getColonies(), c -> ourCount(c.getBuildings()));
                        break;
                    case SETTLEMENTS:
                        result += ourCount(player.getSettlementList());
                        break;
                    case FOUNDING_FATHERS:
                        result += ourCount(player.getFathers());
                        break;
                    default:
                        return null;
                }
            }
    }
    return result;
}