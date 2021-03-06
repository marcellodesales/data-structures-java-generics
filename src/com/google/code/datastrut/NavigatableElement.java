package com.google.code.datastrut;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class NavigatableElement<Type> {

    private NavigatableElement<Type> previous;
    private Type value;
    private NavigatableElement<Type> next;

    public NavigatableElement(Type newValue) {
        Preconditions.checkArgument(newValue != null, "The new value must be provided.");
        this.value = newValue;
    }

    public NavigatableElement<Type> getPrevious() {
        return previous;
    }

    public void setPrevious(NavigatableElement<Type> previous) {
        this.previous = previous;
    }

    public Type getValue() {
        return this.value;
    }

    public NavigatableElement<Type> getNext() {
        return this.next;
    }

    public void setNext(NavigatableElement<Type> next) {
        this.next = next;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        NavigatableElement<Type> other = (NavigatableElement) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", this.value).add("next", this.next)
            .add("previous", previous).toString();
    }

}
