public boolean setBuildQueue(Colony colony, List<BuildableType> buildQueue) {
    return ask(colony.getGame(), new SetBuildQueueMessage(colony, buildQueue));
}