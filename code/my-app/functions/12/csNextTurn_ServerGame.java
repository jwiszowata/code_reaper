public void csNextTurn(ChangeSet cs) {
    String duration = null;
    long now = new Date().getTime();
    if (lastTime >= 0) {
        duration = ", previous turn duration = " + (now - lastTime) + "ms";
    }
    lastTime = now;
    Session.completeAll(cs);
    setTurn(getTurn().next());
    logger.finest("Turn is now " + getTurn() + duration);
    cs.add(See.all(), new NewTurnMessage(getTurn()));
}