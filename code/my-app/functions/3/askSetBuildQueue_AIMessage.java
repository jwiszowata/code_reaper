public static boolean askSetBuildQueue(AIColony aiColony, List<BuildableType> queue) {
    return aiColony.getAIOwner().askServer().setBuildQueue(aiColony.getColony(), queue);
}