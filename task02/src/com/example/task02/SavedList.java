package com.example.task02;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class SavedList<E extends Serializable> extends AbstractList<E> {
    private final File file;
    private List<E> elements;

    public SavedList(File file) {
        this.file = file;
        this.elements = new ArrayList<>();
        loadFromFile();
    }

    private void loadFromFile() {
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                elements = (List<E>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                elements = new ArrayList<>();
            }
        } else {
            elements = new ArrayList<>();
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(elements);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return elements.get(index);
    }

    @Override
    public E set(int index, E element) {
        E oldElement = elements.set(index, element);
        saveToFile();
        return oldElement;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(int index, E element) {
        elements.add(index, element);
        saveToFile();
    }

    @Override
    public E remove(int index) {
        E removedElement = elements.remove(index);
        saveToFile();
        return removedElement;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
