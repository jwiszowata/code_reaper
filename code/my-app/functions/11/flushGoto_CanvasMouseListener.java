private boolean flushGoto() {
    if (canvas.isGotoStarted()) {
        PathNode path = canvas.getGotoPath();
        canvas.stopGoto();
        if (path != null) {
            getFreeColClient().getInGameController().goToTile(canvas.getActiveUnit(), path.getLastNode().getTile());
        }
        return true;
    }
    return false;
}