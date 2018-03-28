public static void stepRNG(FreeColClient freeColClient) {
    final FreeColServer server = freeColClient.getFreeColServer();
    final GUI gui = freeColClient.getGUI();
    boolean more = true;
    while (more) {
        int val = server.getInGameController().stepRandom();
        more = gui.confirm(null, StringTemplate.template("prompt.stepRNG").addAmount("%value%", val), "more", "cancel");
    }
}