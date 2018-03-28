public <T extends AIObject> T getAIObject(String id, Class<T> returnClass) {
    AIObject aio = getAIObject(id);
    try {
        return returnClass.cast(aio);
    } catch (ClassCastException e) {
        return null;
    }
}