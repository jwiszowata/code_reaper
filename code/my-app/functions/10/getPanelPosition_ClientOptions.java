public Point getPanelPosition(String className) {
    OptionGroup etc = getOptionGroup(ETC);
    if (etc == null)
        return null;
    try {
        return new Point(etc.getInteger(className + ".x"), etc.getInteger(className + ".y"));
    } catch (Exception e) {
    }
    return null;
}