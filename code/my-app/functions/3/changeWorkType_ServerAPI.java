public boolean changeWorkType(Unit unit, GoodsType workType) {
    return ask(unit.getGame(), new ChangeWorkTypeMessage(unit, workType));
}