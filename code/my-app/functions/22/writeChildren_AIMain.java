protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    for (AIObject aio : sort(getAIObjects())) {
        if (aio.checkIntegrity(false) < 0) {
            aio.dispose();
            continue;
        }
        if (aio instanceof Wish) {
            if (!((Wish) aio).shouldBeStored())
                continue;
        }
        try {
            if (aio.getId() == null) {
                logger.warning("Null AI identifier for: " + aio.getClass().getName());
            } else {
                aio.toXML(xw);
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to write AI object: " + aio, e);
        }
    }
}