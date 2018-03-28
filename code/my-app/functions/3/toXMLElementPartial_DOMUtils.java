public static Element toXMLElementPartial(FreeColObject fco, Document document, List<String> fields) {
    return toXMLElement(fco, document, WriteScope.toServer(), fields);
}