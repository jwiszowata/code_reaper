public void dispose() {
    dropTransport();
    if (destination != null) {
        if (destination instanceof Colony) {
            AIColony aic = getAIMain().getAIColony((Colony) destination);
            if (aic != null)
                aic.removeExportGoods(this);
        } else if (destination instanceof Europe) {
        } else {
            logger.warning("Unknown type of destination: " + destination);
        }
        destination = null;
    }
    goods = null;
    super.dispose();
}