public static synchronized void clean() {
    if (baseMapping != null) {
        forEachMapEntry(baseMapping.getImageResources(), e -> e.getValue().clean());
    }
    if (tcMapping != null) {
        forEachMapEntry(tcMapping.getImageResources(), e -> e.getValue().clean());
    }
    if (scenarioMapping != null) {
        forEachMapEntry(scenarioMapping.getImageResources(), e -> e.getValue().clean());
    }
    if (modMapping != null) {
        forEachMapEntry(modMapping.getImageResources(), e -> e.getValue().clean());
    }
    System.gc();
}