public Element toXMLElement() {
    return new DOMMessage(TAG, WINNER_TAG, this.winnerId, LOSER_TAG, this.loserId).add(this.goods).toXMLElement();
}