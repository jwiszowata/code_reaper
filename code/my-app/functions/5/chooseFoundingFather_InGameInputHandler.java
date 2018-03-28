private void chooseFoundingFather(ChooseFoundingFatherMessage message) {
    final Game game = getGame();
    final List<FoundingFather> fathers = message.getFathers(game);
    invokeLater(() -> igc().chooseFoundingFather(fathers));
}