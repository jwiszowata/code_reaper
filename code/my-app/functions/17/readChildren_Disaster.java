protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        effects = null;
    }
    final Specification spec = getSpecification();
    Disaster parent = xr.getType(spec, EXTENDS_TAG, Disaster.class, this);
    if (parent != this && !parent.getEffects().isEmpty()) {
        if (effects == null)
            effects = new ArrayList<>();
        for (RandomChoice<Effect> choice : parent.getEffects()) {
            Effect effect = new Effect(choice.getObject());
            effect.getFeatureContainer().replaceSource(parent, this);
            addEffect(effect);
        }
    }
    super.readChildren(xr);
}