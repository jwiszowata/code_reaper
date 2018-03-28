public boolean login(String userName, String version, boolean single, boolean current) {
    return ask(null, new LoginMessage(userName, version, null, single, current, null));
}