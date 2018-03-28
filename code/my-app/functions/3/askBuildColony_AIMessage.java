public static boolean askBuildColony(AIUnit aiUnit, String name) {
    return aiUnit.getAIOwner().askServer().buildColony(name, aiUnit.getUnit());
}