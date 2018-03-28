public <T extends Mission> T getMission(Class<T> returnClass) {
    try {
        return returnClass.cast(this.mission);
    } catch (ClassCastException cce) {
        return null;
    }
}