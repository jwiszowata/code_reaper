protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    if (xr.shouldClearContainers()) {
        consumption = null;
    }
    defaultRole = spec.getDefaultRole();
    UnitType parent = xr.getType(spec, EXTENDS_TAG, UnitType.class, this);
    if (parent != this) {
        defaultRole = parent.defaultRole;
        if (parent.consumption != null) {
            if (consumption == null)
                consumption = new TypeCountMap<>();
            consumption.putAll(parent.consumption);
        }
        addFeatures(parent);
        if (parent.isAbstractType()) {
            getFeatureContainer().replaceSource(parent, this);
        }
    }
    super.readChildren(xr);
    if (hasAbility(Ability.PERSON)) {
        Modifier m;
        if (!containsModifierKey(Modifier.CONVERSION_SKILL)) {
            m = new Modifier(Modifier.CONVERSION_SKILL, 8.0f, Modifier.ModifierType.ADDITIVE);
            addModifier(m);
            if (hasAbility(Ability.EXPERT_MISSIONARY)) {
                m = new Modifier(Modifier.CONVERSION_SKILL, 5.0f, Modifier.ModifierType.ADDITIVE);
                addModifier(m);
            }
        }
        if (!containsModifierKey(Modifier.CONVERSION_ALARM_RATE)) {
            m = new Modifier(Modifier.CONVERSION_ALARM_RATE, 2.0f, Modifier.ModifierType.PERCENTAGE);
            addModifier(m);
        }
    }
}