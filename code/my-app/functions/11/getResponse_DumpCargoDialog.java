public List<Goods> getResponse() {
    Object value = getValue();
    List<Goods> gl = new ArrayList<>();
    if (options.get(0).equals(value)) {
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isSelected())
                gl.add(goodsList.get(i));
        }
    }
    return gl;
}