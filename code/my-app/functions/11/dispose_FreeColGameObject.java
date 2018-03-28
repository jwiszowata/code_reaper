public final void dispose() {
    if (this.disposed)
        return;
    LogBuilder lb = new LogBuilder(64);
    lb.add("Destroying:");
    for (FreeColGameObject fcgo : toList(getDisposables())) {
        lb.add(" ", fcgo.getId());
        fcgo.disposeResources();
    }
    lb.log(logger, Level.INFO);
}