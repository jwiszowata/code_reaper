public void nonServerBuildColony(Unit builder, Colony colony) {
    colony.placeSettlement(true);
    colony.getOwner().invalidateCanSeeTiles();
    nonServerJoinColony(builder, colony);
}