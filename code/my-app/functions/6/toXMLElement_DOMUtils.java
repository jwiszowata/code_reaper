public static Element toXMLElement(FreeColObject fco, Document document, WriteScope writeScope) {
    if (!writeScope.isValid()) {
        throw new IllegalStateException("Invalid write scope: " + writeScope);
    }
    return toXMLElement(fco, document, writeScope, null);
}