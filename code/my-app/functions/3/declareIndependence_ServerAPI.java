public boolean declareIndependence(Game game, String nation, String country) {
    return ask(game, new DeclareIndependenceMessage(nation, country));
}