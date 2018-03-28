protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (xw.validFor(this.player)) {
        getExpeditionaryForce().toXML(xw, EXPEDITIONARY_FORCE_TAG);
        getInterventionForce().toXML(xw, INTERVENTION_FORCE_TAG);
    }
}