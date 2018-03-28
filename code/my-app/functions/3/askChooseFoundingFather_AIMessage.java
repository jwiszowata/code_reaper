public static boolean askChooseFoundingFather(AIPlayer aiPlayer, List<FoundingFather> fathers, FoundingFather father) {
    return aiPlayer.askServer().chooseFoundingFather(fathers, father);
}