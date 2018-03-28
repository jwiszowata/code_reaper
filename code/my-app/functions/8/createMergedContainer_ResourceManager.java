private static void createMergedContainer() {
    ResourceMapping mc = new ResourceMapping();
    mc.addAll(baseMapping);
    mc.addAll(tcMapping);
    mc.addAll(scenarioMapping);
    mc.addAll(modMapping);
    mergedContainer = mc;
}