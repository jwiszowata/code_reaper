public ServerPlayer makeAIPlayer(Nation nation) {
    ServerPlayer aiPlayer = new ServerPlayer(getGame(), false, nation);
    aiPlayer.setAI(true);
    aiPlayer.setReady(true);
    addAIConnection(aiPlayer);
    getGame().addPlayer(aiPlayer);
    getAIMain().setFreeColGameObject(aiPlayer.getId(), aiPlayer);
    return aiPlayer;
}