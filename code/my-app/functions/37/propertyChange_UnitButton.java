public void propertyChange(PropertyChangeEvent e) {
    String propertyName = e.getPropertyName();
    if (Action.NAME.equals(e.getPropertyName()) || Action.SHORT_DESCRIPTION.equals(e.getPropertyName())) {
        String text = (String) e.getNewValue();
        button.setToolTipText(text);
    } else if ("enabled".equals(propertyName)) {
        Boolean enabledState = (Boolean) e.getNewValue();
        button.setEnabled(enabledState);
        button.repaint();
    } else if (Action.SMALL_ICON.equals(e.getPropertyName())) {
        Icon icon = (Icon) e.getNewValue();
        button.setIcon(icon);
        button.repaint();
    } else if (FreeColAction.BUTTON_IMAGE.equals(e.getPropertyName())) {
        String key = (String) e.getNewValue();
        button.setIcon(new ImageIcon(ResourceManager.getImage(key)));
        button.repaint();
    } else if (FreeColAction.BUTTON_ROLLOVER_IMAGE.equals(e.getPropertyName())) {
        String key = (String) e.getNewValue();
        button.setRolloverIcon(new ImageIcon(ResourceManager.getImage(key)));
        button.repaint();
    } else if (FreeColAction.BUTTON_PRESSED_IMAGE.equals(e.getPropertyName())) {
        String key = (String) e.getNewValue();
        button.setPressedIcon(new ImageIcon(ResourceManager.getImage(key)));
        button.repaint();
    } else if (FreeColAction.BUTTON_DISABLED_IMAGE.equals(e.getPropertyName())) {
        String key = (String) e.getNewValue();
        button.setDisabledIcon(new ImageIcon(ResourceManager.getImage(key)));
        button.repaint();
    } else if (Action.MNEMONIC_KEY.equals(e.getPropertyName())) {
        Integer mn = (Integer) e.getNewValue();
        button.setMnemonic(mn);
        button.repaint();
    } else if (Action.ACTION_COMMAND_KEY.equals(e.getPropertyName())) {
        button.setActionCommand((String) e.getNewValue());
    }
}