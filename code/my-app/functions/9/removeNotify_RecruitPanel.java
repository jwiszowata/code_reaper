public void removeNotify() {
    super.removeNotify();
    removeAll();
    if (person != null) {
        for (int i = 0; i < person.length; i++) {
            person[i] = null;
        }
    }
}