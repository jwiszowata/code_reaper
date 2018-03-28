public boolean tryPioneeringMission(LogBuilder lb) {
    Mission m = getMission();
    Location oldTarget = (m == null) ? null : m.getTarget();
    AIPlayer aiPlayer = getAIOwner();
    if (aiPlayer instanceof EuropeanAIPlayer) {
        EuropeanAIPlayer euaiPlayer = (EuropeanAIPlayer) getAIOwner();
        if (euaiPlayer.getPioneeringMission(this, null) != null) {
            lb.add(", ", getMission());
            euaiPlayer.updateTransport(this, oldTarget, lb);
            return true;
        }
    }
    return false;
}