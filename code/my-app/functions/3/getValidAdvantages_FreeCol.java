private static String getValidAdvantages() {
    return transform(Advantages.values(), alwaysTrue(), a -> Messages.getName(a), Collectors.joining(","));
}