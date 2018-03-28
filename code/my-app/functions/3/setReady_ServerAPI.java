public boolean setReady(boolean ready) {
    return send(new ReadyMessage(null, ready));
}