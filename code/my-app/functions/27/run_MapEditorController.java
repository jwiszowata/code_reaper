public void run() {
    final FreeColServer freeColServer = getFreeColServer();
    GUI.ErrorJob ej = null;
    try {
        Specification spec = getDefaultSpecification();
        Game game = FreeColServer.readGame(new FreeColSavegameFile(theFile), spec, freeColServer);
        fcc.setGame(game);
        requireNativeNations(game);
        SwingUtilities.invokeLater(() -> {
            gui.closeStatusPanel();
            gui.setFocus(game.getMap().getTile(1, 1));
            gui.updateMenuBar();
            gui.refresh();
        });
    } catch (FileNotFoundException fnfe) {
        ej = gui.errorJob(fnfe, FreeCol.badFile("error.couldNotFind", theFile));
    } catch (IOException ioe) {
        ej = gui.errorJob(ioe, "server.initialize");
    } catch (XMLStreamException xse) {
        ej = gui.errorJob(xse, FreeCol.badFile("error.couldNotLoad", theFile));
    } catch (FreeColException ex) {
        ej = gui.errorJob(ex, "server.initialize");
    }
    if (ej != null) {
        ej.setRunnable(fcc.invokeMainPanel(null)).invokeLater();
    }
}