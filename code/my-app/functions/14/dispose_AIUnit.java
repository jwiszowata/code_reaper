public void dispose() {
    dropTransport();
    AIPlayer aiOwner = getAIOwner();
    if (aiOwner != null) {
        aiOwner.removeAIObject(this);
    } else {
        logger.warning("Disposing of " + getId() + " but owner is null!");
    }
    if (mission != null) {
        this.mission.dispose();
        this.mission = null;
    }
    super.dispose();
}