public boolean trainUnitInEurope(Game game, UnitType type) {
    return ask(game, new TrainUnitInEuropeMessage(type));
}