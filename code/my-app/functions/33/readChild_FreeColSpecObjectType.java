protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (Ability.TAG.equals(tag)) {
        if (xr.getAttribute(DELETE_TAG, false)) {
            removeAbilities(xr.readId());
            xr.closeTag(Ability.TAG);
        } else {
            Ability ability = new Ability(xr, spec);
            if (ability.getSource() == null)
                ability.setSource(this);
            addAbility(ability);
            spec.addAbility(ability);
        }
    } else if (Modifier.TAG.equals(tag)) {
        if (xr.getAttribute(DELETE_TAG, false)) {
            removeModifiers(xr.readId());
            xr.closeTag(Modifier.TAG);
        } else {
            Modifier modifier = new Modifier(xr, spec);
            if (modifier.getSource() == null)
                modifier.setSource(this);
            addModifier(modifier);
            spec.addModifier(modifier);
        }
    } else if (Scope.TAG.equals(tag)) {
        Scope scope = new Scope(xr);
        if (scope != null)
            addScope(scope);
    } else {
        super.readChild(xr);
    }
}