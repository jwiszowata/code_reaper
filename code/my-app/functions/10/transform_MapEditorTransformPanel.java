public void transform(Tile t) {
    if (t.isLand()) {
        LostCityRumour rumour = t.getLostCityRumour();
        if (rumour == null) {
            t.addLostCityRumour(new LostCityRumour(t.getGame(), t));
        } else {
            t.removeLostCityRumour();
        }
    }
}