public void toXML(FreeColXMLWriter xw) throws XMLStreamException {
    xw.writeStartElement(TAG);
    xw.writeAttribute(FreeColObject.ID_ATTRIBUTE_TAG, (AIObject) getTransportable());
    xw.writeAttribute(CARRIER_TAG, getCarrier());
    xw.writeAttribute(TRIES_TAG, getTries());
    xw.writeAttribute(SPACELEFT_TAG, getSpaceLeft());
    if (plan.twait != null) {
        xw.writeLocationAttribute(TWAIT_TAG, plan.twait);
    }
    if (plan.cwait != null) {
        xw.writeLocationAttribute(CWAIT_TAG, plan.cwait);
    }
    if (plan.cdst != null) {
        xw.writeLocationAttribute(CDST_TAG, plan.cdst);
    }
    if (plan.tdst != null) {
        xw.writeLocationAttribute(TDST_TAG, plan.tdst);
    }
    xw.writeAttribute(TURNS_TAG, plan.turns);
    xw.writeAttribute(MODE_TAG, plan.mode);
    xw.writeAttribute(FALLBACK_TAG, plan.fallback);
    xw.writeEndElement();
}