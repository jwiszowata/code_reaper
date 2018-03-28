private List<AIObject> getAIObjects() {
    synchronized (aiObjects) {
        return new ArrayList<>(aiObjects.values());
    }
}