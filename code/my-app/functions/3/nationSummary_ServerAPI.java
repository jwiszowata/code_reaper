public boolean nationSummary(Player self, Player player) {
    return ask(self.getGame(), new NationSummaryMessage(player));
}