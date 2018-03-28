public void showEndTurnDialog(List<Unit> units, DialogHandler<Boolean> handler) {
    SwingUtilities.invokeLater(new DialogCallback<>(new EndTurnDialog(freeColClient, frame, units), null, handler));
}