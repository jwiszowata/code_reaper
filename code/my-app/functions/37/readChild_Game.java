protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Game game = getGame();
    final String tag = xr.getLocalName();
    if (CIBOLA_TAG.equals(tag)) {
        String cibola = xr.readId();
        final String oldPrefix = "lostCityRumour.cityName";
        if (cibola.startsWith(oldPrefix))
            cibola = "nameCache." + cibola;
        NameCache.addCityOfCibola(cibola);
        xr.closeTag(CIBOLA_TAG);
    } else if (Map.TAG.equals(tag)) {
        if (this.specification == null) {
            throw new XMLStreamException("Tried to read " + tag + " with null specification");
        }
        map = xr.readFreeColObject(game, Map.class);
    } else if (NationOptions.TAG.equals(tag)) {
        if (this.specification == null) {
            throw new XMLStreamException("Tried to read " + tag + " with null specification");
        }
        nationOptions = new NationOptions(xr, specification);
    } else if (Player.TAG.equals(tag)) {
        if (this.specification == null) {
            throw new XMLStreamException("Tried to read " + tag + " with null specification");
        }
        Player player = xr.readFreeColObject(game, Player.class);
        if (player.isUnknownEnemy()) {
            setUnknownEnemy(player);
        } else {
            players.add(player);
        }
    } else if (Specification.TAG.equals(tag)) {
        logger.info(((specification == null) ? "Loading" : "Reloading") + " specification.");
        this.specification = new Specification(xr);
    } else {
        super.readChild(xr);
    }
}