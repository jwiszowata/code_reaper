public void update(MapTransform mapTransform) {
    final JPanel p = (mapTransform == null) ? null : mapTransform.getDescriptionPanel();
    if (p != null) {
        p.setOpaque(false);
        final Dimension d = p.getPreferredSize();
        p.setBounds(0, (this.mapEditorPanel.getHeight() - d.height) / 2, this.mapEditorPanel.getWidth(), d.height);
        this.mapEditorPanel.removeAll();
        this.mapEditorPanel.add(p, BorderLayout.CENTER);
        this.mapEditorPanel.validate();
        this.mapEditorPanel.revalidate();
    }
    update();
}