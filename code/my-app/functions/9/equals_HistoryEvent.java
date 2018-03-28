public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof HistoryEvent) {
        HistoryEvent h = (HistoryEvent) o;
        return turn == h.turn && eventType == h.eventType && Utils.equals(playerId, h.playerId) && score == h.score;
    }
    return false;
}