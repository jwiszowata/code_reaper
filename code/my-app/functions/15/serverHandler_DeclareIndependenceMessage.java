public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String nationName = getStringAttribute(NATION_NAME_TAG);
    final String countryName = getStringAttribute(COUNTRY_NAME_TAG);
    if (nationName == null || nationName.isEmpty()) {
        return serverPlayer.clientError("Empty nation name.");
    }
    if (countryName == null || countryName.isEmpty()) {
        return serverPlayer.clientError("Empty country name.");
    }
    StringTemplate problem = serverPlayer.checkDeclareIndependence();
    if (problem != null) {
        return serverPlayer.clientError("Declaration blocked");
    }
    return freeColServer.getInGameController().declareIndependence(serverPlayer, nationName, countryName);
}