public static void displayEurope(final FreeColClient freeColClient) {
    final FreeColServer server = freeColClient.getFreeColServer();
    final Game sGame = server.getGame();
    final AIMain aiMain = server.getAIMain();
    LogBuilder lb = new LogBuilder(256);
    List<Unit> inEurope = new ArrayList<>();
    List<Unit> toEurope = new ArrayList<>();
    List<Unit> toAmerica = new ArrayList<>();
    HashMap<String, List<Unit>> units = new HashMap<>();
    for (Player tp : sGame.getLiveEuropeanPlayerList()) {
        Player p = sGame.getFreeColGameObject(tp.getId(), Player.class);
        if (p.getEurope() == null)
            continue;
        inEurope.clear();
        toEurope.clear();
        toAmerica.clear();
        units.clear();
        units.put(Messages.message("sailingToEurope"), toEurope);
        units.put(Messages.getName(p.getEurope()), inEurope);
        units.put(Messages.message("sailingToAmerica"), toAmerica);
        lb.add("\n==", Messages.message(p.getCountryLabel()), "==\n");
        for (Unit u : p.getEurope().getUnitList()) {
            if (u.getDestination() instanceof Map) {
                toAmerica.add(u);
            } else if (u.getDestination() instanceof Europe) {
                toEurope.add(u);
            } else {
                inEurope.add(u);
            }
        }
        forEachMapEntry(units, e -> logEurope(aiMain, lb, e.getKey(), e.getValue()));
        lb.add("\n->", Messages.message("immigrants"), "\n\n");
        for (UnitType unitType : p.getEurope().getRecruitables()) {
            lb.add(Messages.getName(unitType), "\n");
        }
        lb.add("\n");
    }
    freeColClient.getGUI().showInformationMessage(lb.toString());
}