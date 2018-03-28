protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (EFFECT_TAG.equals(tag)) {
        Effect effect = new Effect(xr, spec);
        effect.getFeatureContainer().replaceSource(null, this);
        addEffect(effect);
    } else {
        super.readChild(xr);
    }
}