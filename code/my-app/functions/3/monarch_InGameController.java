public void monarch(MonarchAction action, StringTemplate template, String monarchKey) {
    getGUI().showMonarchDialog(action, template, monarchKey, (Boolean b) -> monarchAction(action, b));
}