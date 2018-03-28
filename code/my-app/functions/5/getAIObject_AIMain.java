public AIObject getAIObject(String id) {
    synchronized (aiObjects) {
        return aiObjects.get(id);
    }
}