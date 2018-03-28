private static void collectNames(String prefix, List<String> names) {
    String name;
    if (Messages.containsKey(name = prefix + "0")) {
        names.add(Messages.message(name));
    }
    int i = 1;
    while (Messages.containsKey(name = prefix + Integer.toString(i))) {
        names.add(Messages.message(name));
        i++;
    }
}