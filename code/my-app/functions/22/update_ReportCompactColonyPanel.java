private void update() {
    reportPanel.removeAll();
    StringBuilder sb = new StringBuilder(64);
    sb.append("[l][c][c][c]");
    for (int i = 0; i < this.goodsTypes.size(); i++) sb.append("[c]");
    sb.append("[c][c][l][l][l]");
    reportPanel.setLayout(new MigLayout("fillx, insets 0, gap 0 0", sb.toString(), ""));
    conciseHeaders(this.market);
    List<ColonySummary> summaries = new ArrayList<>();
    for (List<Colony> cs : this.colonies) {
        summaries.clear();
        for (Colony c : cs) {
            ColonySummary s = new ColonySummary(c, this.goodsTypes);
            summaries.add(s);
            updateColony(s);
        }
        if (cs.size() > 1) {
            updateCombinedColonies(summaries);
        }
        conciseHeaders(this.market);
    }
}