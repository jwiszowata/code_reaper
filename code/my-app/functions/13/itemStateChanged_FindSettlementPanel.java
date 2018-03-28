public void itemStateChanged(ItemEvent event) {
    switch(this.displayOptionBox.getSelectedIndex()) {
        case 0:
        default:
            updateSearch(DisplayListOption.valueOf("ALL"));
            break;
        case 1:
            updateSearch(DisplayListOption.valueOf("ONLY_NATIVES"));
            break;
        case 2:
            updateSearch(DisplayListOption.valueOf("ONLY_EUROPEAN"));
    }
}