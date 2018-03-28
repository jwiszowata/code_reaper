public boolean cashInTreasureTrain(Unit unit) {
    return ask(unit.getGame(), new CashInTreasureTrainMessage(unit));
}