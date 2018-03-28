public TradeStatus acceptDiplomaticTrade(DiplomaticTrade agreement) {
    final Player player = getPlayer();
    final Player other = agreement.getOtherPlayer(player);
    final boolean franklin = other.hasAbility(Ability.ALWAYS_OFFERED_PEACE);
    final java.util.Map<TradeItem, Integer> scores = new HashMap<>();
    TradeItem peace = null;
    TradeStatus result = null;
    LogBuilder lb = new LogBuilder(64);
    lb.add("Evaluate trade offer to ", player.getName(), " from ", other.getName());
    if (agreement.getVersion() == 0) {
        result = TradeStatus.PROPOSE_TRADE;
    } else {
        int unacceptable = 0, value = 0;
        for (TradeItem item : agreement.getTradeItems()) {
            if (item instanceof StanceTradeItem) {
                getNationSummary(other);
            }
            int score = item.evaluateFor(player);
            if (item instanceof StanceTradeItem) {
                switch(item.getStance()) {
                    case ALLIANCE:
                    case CEASE_FIRE:
                        if (franklin) {
                            peace = item;
                            score = 0;
                        }
                        break;
                    case UNCONTACTED:
                    case PEACE:
                        if (agreement.getContext() == TradeContext.CONTACT) {
                            peace = item;
                            score = 0;
                        }
                        break;
                    default:
                        break;
                }
            }
            if (score == Integer.MIN_VALUE) {
                unacceptable++;
            } else if (item.getSource() == player) {
                score = -score;
            }
            scores.put(item, score);
            lb.add(", ", Messages.message(item.getLabel()), " = ", score);
            if (score != Integer.MIN_VALUE)
                value += score;
        }
        lb.add(".");
        if (unacceptable == 0 && value >= 0) {
            result = TradeStatus.ACCEPT_TRADE;
            lb.add("  All accepted at ", value, ".");
        } else {
            double ratio = (double) unacceptable / (unacceptable + agreement.getTradeItems().size());
            if (ratio > 0.5 - 0.5 * agreement.getVersion()) {
                result = rejectAgreement(peace, agreement);
                lb.add("  Too many (", unacceptable, ") unacceptable.");
            }
        }
        if (result == null) {
            for (Entry<TradeItem, Integer> entry : scores.entrySet()) {
                if (entry.getValue() == Integer.MIN_VALUE) {
                    agreement.remove(entry.getKey());
                    lb.add("  Dropped invalid ", entry.getKey(), ".");
                } else {
                    value += entry.getValue();
                    lb.add("  Added valid ", entry.getKey(), ", total = ", value, ".");
                }
            }
            if (agreement.isEmpty()) {
                result = rejectAgreement(peace, agreement);
            }
        }
        if (randomInt(logger, "Enough diplomacy?", getAIRandom(), 1 + agreement.getVersion()) > 5) {
            result = rejectAgreement(peace, agreement);
            lb.add("  Ran out of patience at ", agreement.getVersion(), ".");
        }
        if (result == null) {
            for (Entry<TradeItem, Integer> e : mapEntriesByValue(scores, ascendingIntegerComparator)) {
                if (value >= 0)
                    break;
                TradeItem item = e.getKey();
                value -= e.getValue();
                if (value >= 50 && item instanceof GoldTradeItem) {
                    GoldTradeItem gti = (GoldTradeItem) item;
                    gti.setGold(gti.getGold() - value / 2);
                    value /= 2;
                    lb.add("  Reducing gold item to ", gti.getGold(), ".");
                } else {
                    agreement.remove(item);
                    lb.add("  Dropped ", item, ", value now = ", value, ".");
                }
            }
            if (value >= 0 && !agreement.isEmpty()) {
                result = TradeStatus.PROPOSE_TRADE;
                lb.add("  Pruned until acceptable at ", value, ".");
            } else {
                result = rejectAgreement(peace, agreement);
                lb.add("  Agreement unsalvageable at ", value, ".");
            }
        }
    }
    lb.add(" => ", result);
    lb.log(logger, Level.INFO);
    return result;
}