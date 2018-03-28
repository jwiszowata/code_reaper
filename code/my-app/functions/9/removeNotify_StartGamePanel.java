public void removeNotify() {
    start.removeActionListener(startCmd);
    cancel.removeActionListener(cancelCmd);
    readyBox.removeActionListener(readyBoxCmd);
    gameOptions.removeActionListener(gameOptionsCmd);
    mapGeneratorOptions.removeActionListener(mapGeneratorOptionsCmd);
    if (chat != null)
        chat.removeActionListener(chatCmd);
}