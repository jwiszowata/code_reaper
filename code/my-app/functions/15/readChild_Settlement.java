protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (Ability.TAG.equals(tag)) {
        Ability ability = new Ability(xr, spec);
        if (ability.isIndependent())
            addAbility(ability);
    } else if (Modifier.TAG.equals(tag)) {
        Modifier modifier = new Modifier(xr, spec);
        if (modifier.isIndependent())
            addModifier(modifier);
    } else {
        super.readChild(xr);
    }
}