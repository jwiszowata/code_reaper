public static boolean setGUIScale(String arg) {
    boolean valid = true;
    if (arg == null) {
        guiScale = GUI_SCALE_MAX;
    } else {
        try {
            int n = Integer.parseInt(arg);
            if (n < GUI_SCALE_MIN_PCT) {
                valid = false;
                n = GUI_SCALE_MIN_PCT;
            } else if (n > GUI_SCALE_MAX_PCT) {
                valid = false;
                n = GUI_SCALE_MAX_PCT;
            } else if (n % GUI_SCALE_STEP_PCT != 0) {
                valid = false;
            }
            guiScale = ((float) n / GUI_SCALE_STEP_PCT) * GUI_SCALE_STEP;
        } catch (NumberFormatException nfe) {
            valid = false;
            guiScale = GUI_SCALE_MAX;
        }
    }
    return valid;
}