public static StringTemplate getListLabel(String base, List<AbstractUnit> units) {
    StringTemplate template = StringTemplate.label(base);
    for (AbstractUnit au : units) {
        template.addStringTemplate(au.getLabel());
    }
    return template;
}