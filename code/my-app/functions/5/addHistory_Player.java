public void addHistory(HistoryEvent event) {
    synchronized (this.history) {
        this.history.add(event);
    }
}