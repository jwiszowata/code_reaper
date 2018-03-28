protected final MissionAIPlayer getAIPlayer() {
    return (MissionAIPlayer) getAIMain().getAIPlayer(getUnit().getOwner());
}