public String serialize(Player player) throws XMLStreamException {
    return serialize(WriteScope.toClient(player));
}