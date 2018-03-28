public Dimension getPanelSize(String className) {
    OptionGroup etc = getOptionGroup(ETC);
    if (etc == null)
        return null;
    try {
        return new Dimension(etc.getInteger(className + ".w"), etc.getInteger(className + ".h"));
    } catch (Exception e) {
    }
    return null;
}