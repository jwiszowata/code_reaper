private void output(List<Modifier> modifiers, UnitType unitType) {
    for (Modifier m : modifiers) {
        JLabel[] mLabels = ModifierFormat.getModifierLabels(m, unitType, turn);
        for (int i = 0; i < mLabels.length; i++) {
            if (mLabels[i] == null)
                continue;
            if (i == 0) {
                add(mLabels[i], "newline");
            } else {
                add(mLabels[i]);
            }
        }
    }
}