public void exploreMapForAllPlayers(boolean reveal) {
    for (Player player : getGame().getLiveEuropeanPlayerList()) {
        ((ServerPlayer) player).exploreMap(reveal);
    }
    BooleanOption fogOfWarSetting = getSpecification().getBooleanOption(GameOptions.FOG_OF_WAR);
    if (reveal) {
        FreeColDebugger.setNormalGameFogOfWar(fogOfWarSetting.getValue());
        fogOfWarSetting.setValue(Boolean.FALSE);
    } else {
        fogOfWarSetting.setValue(FreeColDebugger.getNormalGameFogOfWar());
    }
    for (Player player : getGame().getLiveEuropeanPlayerList()) {
        ((ServerPlayer) player).getConnection().sendReconnect();
    }
}