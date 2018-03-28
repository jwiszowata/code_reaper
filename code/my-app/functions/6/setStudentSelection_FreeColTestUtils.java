public static boolean setStudentSelection(boolean value) {
    BooleanOption allowStudentSelection = FreeColTestCase.spec().getBooleanOption(GameOptions.ALLOW_STUDENT_SELECTION);
    boolean ret = allowStudentSelection.getValue();
    allowStudentSelection.setValue(value);
    return ret;
}