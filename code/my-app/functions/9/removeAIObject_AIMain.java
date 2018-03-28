public boolean removeAIObject(String id) {
    boolean result;
    synchronized (aiObjects) {
        result = aiObjects.remove(id) != null;
    }
    if (result)
        logger.finest("Removed AI object: " + id);
    return result;
}