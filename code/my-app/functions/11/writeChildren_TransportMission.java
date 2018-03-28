protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    final AIUnit aiCarrier = getAIUnit();
    for (Cargo cargo : tCopy()) {
        String reason = cargo.check(aiCarrier);
        if (reason != null)
            continue;
        if (cargo.getMode() == Cargo.CargoMode.DUMP)
            continue;
        cargo.toXML(xw);
    }
}