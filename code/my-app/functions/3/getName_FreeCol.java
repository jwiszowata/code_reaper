public static String getName() {
    return (name != null) ? name : System.getProperty("user.name", Messages.message("main.defaultPlayerName"));
}