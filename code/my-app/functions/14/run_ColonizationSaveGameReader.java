private void run() {
    GameData gameData = new GameData(data);
    gameData.print();
    for (int index = 0; index < 4; index++) {
        System.out.println("Nation is " + NATIONS[index]);
        PlayerData playerData = new PlayerData(data, PLAYER_DATA + index * PlayerData.LENGTH);
        playerData.print();
    }
    int count = gameData.getNumberOfColonies();
    for (int index = 0; index < count; index++) {
        ColonyData colonyData = new ColonyData(data, COLONY_DATA + index * ColonyData.LENGTH);
        colonyData.print();
    }
}