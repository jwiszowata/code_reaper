private void rearrangeColonies(LogBuilder lb) {
    for (AIColony aic : getAIColonies()) aic.rearrangeColony(lb);
}