public boolean scoutSpeakToChief(Unit unit, IndianSettlement is) {
    return ask(unit.getGame(), new ScoutSpeakToChiefMessage(unit, is, null));
}