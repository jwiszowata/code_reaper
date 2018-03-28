private boolean continueIgnoreMessage(String key, Turn turn) {
    Integer value = -1;
    boolean ret = key != null && (value = messagesToIgnore.get(key)) != null && value + 1 == turn.getNumber();
    if (ret)
        messagesToIgnore.put(key, value + 1);
    return ret;
}