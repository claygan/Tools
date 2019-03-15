package com.quest.test.beanUtils.entitys;

public class Product implements Cloneable {
    private String name;
    private int length;
    private Element element;

    public Product(String name, int length,Element element) {
        this.name = name;
        this.length = length;
        this.element = element;
    }

    /**
     * 实现Cloneable接口，重写clone方法，实现浅拷贝
     */
    @Override
    public Product clone(){
        try {
            Product p = (Product)super.clone();
            p.setElement(p.getElement().clone());
            return p;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", element=" + element +
                '}';
    }
}
