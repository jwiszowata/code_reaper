protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (Scope.TAG.equals(tag)) {
        Scope scope = new Scope(xr);
        if (scope != null)
            addScope(scope);
    } else {
        super.readChild(xr);
    }
}