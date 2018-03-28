public boolean isAutomaticBuild() {
    return !needsGoodsToBuild() && getUpgradesFrom() == null;
}