public void showVictoryDialog(DialogHandler<Boolean> handler) {
    SwingUtilities.invokeLater(new DialogCallback<>(new VictoryDialog(freeColClient, frame), null, handler));
}