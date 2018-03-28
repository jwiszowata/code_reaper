public void chooseFoundingFather(List<FoundingFather> ffs) {
    if (ffs == null || ffs.isEmpty())
        return;
    getGUI().showChooseFoundingFatherDialog(ffs, (FoundingFather ff) -> chooseFoundingFather(ffs, ff));
}