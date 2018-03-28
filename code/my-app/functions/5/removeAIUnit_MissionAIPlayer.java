private void removeAIUnit(AIUnit aiu) {
    aiu.dropTransport();
    aiu.changeMission(null);
    aiUnits.remove(aiu);
}