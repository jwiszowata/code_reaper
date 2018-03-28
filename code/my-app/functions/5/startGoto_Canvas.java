public void startGoto() {
    setCursor((java.awt.Cursor) UIManager.get("cursor.go"));
    mapViewer.startGoto();
    refresh();
}