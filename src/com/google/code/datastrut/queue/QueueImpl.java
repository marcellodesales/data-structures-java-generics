package com.google.code.datastrut.queue;

import java.util.Iterator;

import com.google.code.datastrut.Element;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

public class QueueImpl<Type> implements Queue<Type> {

    private Element<Type> head, tail;
    private int size;

    @Override
    public void enqueue(Type newElement) {
        Preconditions.checkArgument(newElement != null, "The new value to be enqueued must be provided.");

        Element<Type> newTail = new Element<Type>(newElement);
        if (this.size == 0) {
            this.head = newTail;
        } else {
            this.tail.setNext(newTail);
        }
        this.tail = newTail;
        this.size++;
    }

    @Override
    public Type dequeue() {
        Preconditions.checkState(this.size > 0, "The queue is empty.");

        Type value = this.head.getValue();
        this.head = this.head.getNext();
        this.size--;
        if (this.size == 0) {
            this.tail = null;
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Head - " + this.head);
        builder.append("Tail - " + this.tail);
        Joiner.on(", ").appendTo(builder, this);
        return builder.toString();
    }

    @Override
    public Iterator<Type> iterator() {
        Iterator<Type> it = new Iterator<Type>() {

            Element<Type> current = head;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public Type next() {
                Type val = this.current.getValue();
                this.current = this.current.getNext();
                return val;
            }

            @Override
            public void remove() {
                // TODO Auto-generated method stub
                
            }
        };
        return it;
    }

    @Override
    public int size() {
        return this.size;
    }
    

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Type front() {
        return this.head.getValue();
    }

    @Override
    public Type back() {
        return this.tail.getValue();
    }

    public static void main(String[] args) {
        QueueImpl<Integer> line = new QueueImpl<Integer>();
        for (int i = 1; i <= 10; i++) {
            line.enqueue(i);
        }

        // printing with iterator
        for (Integer value : line) {
            System.out.print(value + ", ");
        }
        System.out.println();

        System.out.println("All the elements joined by Google Guava");
        System.out.println(Joiner.on(", ").join(line));

        for (int i = 0; i < 10; i++) {
            System.out.println("######### Current State #########");
            System.out.println(line);
            Integer retrieved = line.dequeue();
            System.out.println("Removed: " + retrieved);
            System.out.println();
        }
    }

}
