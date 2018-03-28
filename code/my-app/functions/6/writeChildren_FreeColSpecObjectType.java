protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (Ability ability : sort(getAbilities())) ability.toXML(xw);
    for (Modifier modifier : getSortedModifiers()) modifier.toXML(xw);
    for (Scope scope : getScopeList()) scope.toXML(xw);
}