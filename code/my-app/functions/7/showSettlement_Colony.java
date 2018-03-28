public void showSettlement(Canvas canvas, Player p) throws IllegalStateException {
    if (this.getOwner().equals(p)) {
        canvas.showColonyPanel(this, null);
    } else if (FreeColDebugger.isInDebugMode(FreeColDebugger.DebugMode.MENUS)) {
        canvas.showForeignColony(this);
    }
}