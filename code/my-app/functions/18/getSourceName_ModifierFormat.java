private static String getSourceName(FreeColObject source) {
    if (source == null)
        return getUnknownValue();
    String result = null;
    if (result == null && source instanceof Nameable) {
        result = ((Nameable) source).getName();
        if (result != null && result.isEmpty())
            result = null;
    }
    if (result == null && source instanceof Named) {
        result = Messages.getName((Named) source);
        if (result != null && result.isEmpty())
            result = null;
    }
    if (result == null)
        result = Messages.getName(source.getId());
    return result;
}