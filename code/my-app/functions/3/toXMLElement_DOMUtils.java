public static Element toXMLElement(FreeColObject fco, Document document, Player player) {
    return toXMLElement(fco, document, ((player == null) ? WriteScope.toServer() : WriteScope.toClient(player)), null);
}