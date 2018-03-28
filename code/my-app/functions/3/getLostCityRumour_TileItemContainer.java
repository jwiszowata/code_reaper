public final LostCityRumour getLostCityRumour() {
    return (LostCityRumour) findTileItem(ti -> ti instanceof LostCityRumour);
}