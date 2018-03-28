public static boolean askTrainUnitInEurope(AIPlayer aiPlayer, UnitType type) {
    return aiPlayer.askServer().trainUnitInEurope(aiPlayer.getGame(), type);
}