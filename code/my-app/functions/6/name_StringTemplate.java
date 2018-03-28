public static StringTemplate name(String value) {
    if (value == null) {
        net.sf.freecol.FreeCol.trace(logger, "Null name template");
    }
    return new StringTemplate(value, null, TemplateType.NAME);
}