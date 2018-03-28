public boolean chooseFoundingFather(List<FoundingFather> ffs, FoundingFather ff) {
    if (ffs == null)
        return false;
    final Player player = getMyPlayer();
    player.setCurrentFather(ff);
    return askServer().chooseFoundingFather(ffs, ff);
}