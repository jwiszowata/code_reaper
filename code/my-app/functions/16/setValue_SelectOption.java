public void setValue(Integer value) {
    Set<Integer> keys = getItemValues().keySet();
    if (keys.isEmpty())
        return;
    Integer fallback = null;
    for (Integer i : keys) {
        if (i.compareTo(value) == 0) {
            super.setValue(value);
            return;
        }
        if (fallback == null)
            fallback = i;
    }
    logger.warning(TAG + ".setValue invalid value: " + value + ", using fallback: " + fallback);
    super.setValue(fallback);
}