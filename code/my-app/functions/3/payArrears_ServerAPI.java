public boolean payArrears(Game game, GoodsType type) {
    return ask(game, new PayArrearsMessage(type));
}