public static void unitMove(FreeColClient freeColClient, Unit unit, Tile source, Tile destination) {
    new UnitMoveAnimation(freeColClient, unit, source, destination).animate();
}