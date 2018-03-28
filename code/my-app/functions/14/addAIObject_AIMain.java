public void addAIObject(String id, AIObject aiObject) {
    if (aiObject == null) {
        throw new NullPointerException("aiObject == null");
    }
    boolean present;
    synchronized (aiObjects) {
        present = aiObjects.containsKey(id);
        if (!present)
            aiObjects.put(id, aiObject);
    }
    if (present) {
        throw new RuntimeException("AIObject already created: " + id);
    }
}