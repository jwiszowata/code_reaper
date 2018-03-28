public <T extends WorkLocation> T getWorkLocationWithAbility(String ability, Class<T> returnClass) {
    WorkLocation wl = getWorkLocationWithAbility(ability);
    try {
        if (wl != null)
            return returnClass.cast(wl);
    } catch (ClassCastException cce) {
    }
    ;
    return null;
}