public Map createMap(LogBuilder lb) {
    recache(true);
    LandMap landMap = (importGame != null) ? new LandMap(importGame) : new LandMap(mapOptions, random);
    Map map = new TerrainGenerator(game, importGame, random).createMap(landMap, lb);
    makeNativeSettlements(map, lb);
    makeLostCityRumours(map, lb);
    createEuropeanUnits(map, game.getLiveEuropeanPlayerList(), lb);
    return map;
}