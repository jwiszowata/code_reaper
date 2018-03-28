protected void configurePropertiesFromAction(Action a) {
    super.configurePropertiesFromAction(a);
    if (a != null) {
        setRolloverEnabled(true);
        String key = (String) a.getValue(FreeColAction.BUTTON_IMAGE);
        ImageIcon bi = new ImageIcon(ResourceManager.getImage(key));
        setIcon(bi);
        key = (String) a.getValue(FreeColAction.BUTTON_ROLLOVER_IMAGE);
        setRolloverIcon(new ImageIcon(ResourceManager.getImage(key)));
        key = (String) a.getValue(FreeColAction.BUTTON_PRESSED_IMAGE);
        setPressedIcon(new ImageIcon(ResourceManager.getImage(key)));
        key = (String) a.getValue(FreeColAction.BUTTON_DISABLED_IMAGE);
        setDisabledIcon(new ImageIcon(ResourceManager.getImage(key)));
        setToolTipText((String) a.getValue(FreeColAction.NAME));
        setText(null);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setSize(bi.getIconWidth(), bi.getIconHeight());
    }
}