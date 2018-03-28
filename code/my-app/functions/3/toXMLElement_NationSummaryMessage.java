public Element toXMLElement() {
    return new DOMMessage(TAG, PLAYER_TAG, this.playerId).add(summary).toXMLElement();
}