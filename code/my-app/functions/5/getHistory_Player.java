public final List<HistoryEvent> getHistory() {
    synchronized (this.history) {
        return new ArrayList<>(this.history);
    }
}