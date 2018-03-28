public <T extends Mission> boolean hasMission(Class<T> returnClass) {
    return getMission(returnClass) != null;
}