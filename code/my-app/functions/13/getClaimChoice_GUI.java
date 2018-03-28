public ClaimAction getClaimChoice(Tile tile, Player player, int price, Player owner) {
    List<ChoiceItem<ClaimAction>> choices = new ArrayList<>();
    StringTemplate template;
    if (owner.hasContacted(player)) {
        template = StringTemplate.template("indianLand.text").addStringTemplate("%player%", owner.getNationLabel());
        StringTemplate pay = StringTemplate.template("indianLand.pay").addAmount("%amount%", price);
        choices.add(new ChoiceItem<>(Messages.message(pay), ClaimAction.CLAIM_ACCEPT, player.checkGold(price)));
    } else {
        template = StringTemplate.template("indianLand.unknown");
    }
    choices.add(new ChoiceItem<>(Messages.message("indianLand.take"), ClaimAction.CLAIM_STEAL));
    return getChoice(tile, template, owner.getNation(), "indianLand.cancel", choices);
}