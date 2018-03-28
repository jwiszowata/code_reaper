public boolean chooseFoundingFather(List<FoundingFather> ffs, FoundingFather ff) {
    return send(new ChooseFoundingFatherMessage(ffs, ff));
}