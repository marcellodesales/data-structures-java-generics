package com.google.code.datastrut.list;

public class Element<Type> {

    protected Type value;
    protected Element<Type> next;

    public Element(Type newValue) {
        this.value = newValue;
    }

    public Element(Type newValue, Element<Type> next) {
        this.value = newValue;
        this.next = next;
    }

    public Type getValue() {
        return this.value;
    }

    public Element<Type> getNext() {
        return this.next;
    }

    public void setNext(Element<Type> next) {
        this.next = next;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Element other = (Element) obj;
        if (next == null) {
            if (other.next != null)
                return false;
        } else if (!next.equals(other.next))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + ", next=" + next + "]";
    }
}
