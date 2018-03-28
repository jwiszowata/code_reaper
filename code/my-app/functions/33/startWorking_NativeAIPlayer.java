public void startWorking() {
    final Player player = getPlayer();
    final Turn turn = getGame().getTurn();
    final int nSettlements = player.getSettlementCount();
    final Random air = getAIRandom();
    LogBuilder lb = new LogBuilder(1024);
    lb.add(player.getDebugName(), " in ", turn, "/", turn.getNumber());
    clearAIUnits();
    determineStances(lb);
    List<AIUnit> more;
    if (turn.isFirstTurn()) {
        initializeMissions(lb);
        more = getAIUnits();
    } else {
        int[] randoms;
        abortInvalidMissions();
        randoms = randomInts(logger, "Trades", air, nSettlements, nSettlements);
        secureSettlements(randoms, lb);
        randoms = randomInts(logger, "Gifts", air, 100, nSettlements);
        bringGifts(randoms, lb);
        randoms = randomInts(logger, "Tribute", air, 100, nSettlements);
        demandTribute(randoms, lb);
        giveNormalMissions(lb);
        more = doMissions(getAIUnits(), lb);
    }
    if (!more.isEmpty()) {
        abortInvalidMissions();
        giveNormalMissions(lb);
        doMissions(more, lb);
    }
    clearAIUnits();
    lb.log(logger, Level.FINEST);
}