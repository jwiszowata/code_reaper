public boolean isCoastland() {
    return isLand() && getHighSeasCount() > 0;
}