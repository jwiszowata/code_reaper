public void update() {
    for (Nation n : this.nations) nationMap.put(n, null);
    for (Player p : thisPlayer.getGame().getLivePlayerList()) {
        nationMap.put(p.getNation(), p);
    }
    fireTableDataChanged();
}