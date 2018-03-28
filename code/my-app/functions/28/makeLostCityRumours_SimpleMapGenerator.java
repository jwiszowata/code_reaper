private void makeLostCityRumours(Map map, LogBuilder lb) {
    final boolean importRumours = mapOptions.getBoolean(MapGeneratorOptions.IMPORT_RUMOURS);
    if (importGame != null && importRumours)
        return;
    final int rumourNumber = mapOptions.getInteger(MapGeneratorOptions.RUMOUR_NUMBER);
    int number = getApproximateLandCount() / rumourNumber;
    int counter = 0;
    if (importGame != null) {
        number = map.getWidth() * map.getHeight() * 25 / (100 * 35);
    }
    for (int i = 0; i < number; i++) {
        for (int tries = 0; tries < 100; tries++) {
            Tile t = map.getRandomLandTile(random);
            if (t.isPolar())
                continue;
            if (t.isLand() && !t.hasLostCityRumour() && !t.hasSettlement() && t.getUnitCount() == 0) {
                LostCityRumour r = new LostCityRumour(t.getGame(), t);
                if (r.chooseType(null, random) == LostCityRumour.RumourType.MOUNDS && t.getOwningSettlement() != null) {
                    r.setType(LostCityRumour.RumourType.MOUNDS);
                }
                t.addLostCityRumour(r);
                counter++;
                break;
            }
        }
    }
    lb.add("Created ", counter, " lost city rumours of maximum ", number, ".\n");
}