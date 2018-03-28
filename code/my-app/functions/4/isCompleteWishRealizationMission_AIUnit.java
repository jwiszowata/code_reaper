public boolean isCompleteWishRealizationMission(Colony colony) {
    WishRealizationMission wm = getMission(WishRealizationMission.class);
    return (wm != null && Map.isSameLocation(wm.getTarget(), colony));
}