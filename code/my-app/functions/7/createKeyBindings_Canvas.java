private void createKeyBindings() {
    for (Option option : freeColClient.getActionManager().getOptions()) {
        FreeColAction action = (FreeColAction) option;
        getInputMap().put(action.getAccelerator(), action.getId());
        getActionMap().put(action.getId(), action);
    }
}