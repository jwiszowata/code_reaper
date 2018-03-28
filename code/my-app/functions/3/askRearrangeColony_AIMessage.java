public static boolean askRearrangeColony(AIColony aiColony, List<Unit> workers, Colony scratch) {
    return aiColony.getAIOwner().askServer().rearrangeColony(aiColony.getColony(), workers, scratch);
}