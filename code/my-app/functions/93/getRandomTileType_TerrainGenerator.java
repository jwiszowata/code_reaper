private TileType getRandomTileType(List<TileType> candidates, int latitude) {
    final int forestChance = mapOptions.getInteger(MapGeneratorOptions.FOREST_NUMBER);
    final int temperaturePreference = mapOptions.getInteger(MapGeneratorOptions.TEMPERATURE);
    int poleTemperature = -20;
    int equatorTemperature = 40;
    switch(temperaturePreference) {
        case MapGeneratorOptions.TEMPERATURE_COLD:
            poleTemperature = -20;
            equatorTemperature = 25;
            break;
        case MapGeneratorOptions.TEMPERATURE_CHILLY:
            poleTemperature = -20;
            equatorTemperature = 30;
            break;
        case MapGeneratorOptions.TEMPERATURE_TEMPERATE:
            poleTemperature = -10;
            equatorTemperature = 35;
            break;
        case MapGeneratorOptions.TEMPERATURE_WARM:
            poleTemperature = -5;
            equatorTemperature = 40;
            break;
        case MapGeneratorOptions.TEMPERATURE_HOT:
            poleTemperature = 0;
            equatorTemperature = 40;
            break;
        default:
            break;
    }
    final Specification spec = game.getSpecification();
    int temperatureRange = equatorTemperature - poleTemperature;
    int localeTemperature = poleTemperature + (90 - Math.abs(latitude)) * temperatureRange / 90;
    int temperatureDeviation = 7;
    localeTemperature += randomInt(logger, "Temperature", random, temperatureDeviation * 2) - temperatureDeviation;
    localeTemperature = limitToRange(localeTemperature, -20, 40);
    int localeHumidity = spec.getRangeOption(MapGeneratorOptions.HUMIDITY).getValue();
    int humidityDeviation = 20;
    localeHumidity += randomInt(logger, "Humidity", random, humidityDeviation * 2) - humidityDeviation;
    localeHumidity = limitToRange(localeHumidity, 0, 100);
    List<TileType> candidateTileTypes = new ArrayList<>(candidates);
    int i = 0;
    while (i < candidateTileTypes.size()) {
        TileType type = candidateTileTypes.get(i);
        if (!type.withinRange(TileType.RangeType.TEMPERATURE, localeTemperature)) {
            candidateTileTypes.remove(i);
            continue;
        }
        i++;
    }
    switch(candidateTileTypes.size()) {
        case 0:
            throw new RuntimeException("No TileType for" + " temperature==" + localeTemperature);
        case 1:
            return first(candidateTileTypes);
        default:
            break;
    }
    i = 0;
    while (i < candidateTileTypes.size()) {
        TileType type = candidateTileTypes.get(i);
        if (!type.withinRange(TileType.RangeType.HUMIDITY, localeHumidity)) {
            candidateTileTypes.remove(i);
            continue;
        }
        i++;
    }
    switch(candidateTileTypes.size()) {
        case 0:
            throw new RuntimeException("No TileType for" + " humidity==" + localeHumidity);
        case 1:
            return first(candidateTileTypes);
        default:
            break;
    }
    boolean forested = randomInt(logger, "Forest", random, 100) < forestChance;
    i = 0;
    while (i < candidateTileTypes.size()) {
        TileType type = candidateTileTypes.get(i);
        if (type.isForested() != forested) {
            candidateTileTypes.remove(i);
            continue;
        }
        i++;
    }
    switch(i = candidateTileTypes.size()) {
        case 0:
            throw new RuntimeException("No TileType for" + " forested==" + forested);
        case 1:
            return first(candidateTileTypes);
        default:
            return candidateTileTypes.get(randomInt(logger, "Forest tile", random, i));
    }
}