public void readFromXML(FreeColXMLReader xr) throws XMLStreamException {
    String acc = xr.getAttribute(ACCELERATOR_TAG, "");
    putValue(ACCELERATOR_KEY, (acc == null || acc.isEmpty()) ? null : KeyStroke.getKeyStroke(acc));
    xr.closeTag(TAG);
}