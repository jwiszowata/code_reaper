private boolean peaceHolds(Player p) {
    final Player player = getPlayer();
    final Turn turn = getGame().getTurn();
    final double peaceProb = getSpecification().getInteger(GameOptions.PEACE_PROBABILITY) / 100.0;
    int peaceTurn = -1;
    for (HistoryEvent h : player.getHistory()) {
        if (p.getId().equals(h.getPlayerId()) && h.getTurn().getNumber() > peaceTurn) {
            switch(h.getEventType()) {
                case MAKE_PEACE:
                case FORM_ALLIANCE:
                    peaceTurn = h.getTurn().getNumber();
                    break;
                case DECLARE_WAR:
                    peaceTurn = -1;
                    break;
                default:
                    break;
            }
        }
    }
    if (peaceTurn < 0)
        return false;
    int n = turn.getNumber() - peaceTurn;
    float prob = (float) Math.pow(peaceProb, n);
    prob = p.applyModifiers(prob, turn, Modifier.PEACE_TREATY);
    return prob > 0.0f && (randomInt(logger, "Peace holds?", getAIRandom(), 100) < (int) (100.0f * prob));
}