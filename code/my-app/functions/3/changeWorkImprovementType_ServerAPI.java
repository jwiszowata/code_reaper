public boolean changeWorkImprovementType(Unit unit, TileImprovementType type) {
    return ask(unit.getGame(), new ChangeWorkImprovementTypeMessage(unit, type));
}