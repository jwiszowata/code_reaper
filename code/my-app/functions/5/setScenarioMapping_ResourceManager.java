public static synchronized void setScenarioMapping(final ResourceMapping mapping) {
    scenarioMapping = mapping;
    clean();
    update(mapping != null);
}