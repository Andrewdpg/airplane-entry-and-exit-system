package test.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import entity.Plane;
import entity.Section;

public class PlaneTest {

    Plane plane;
    LinkedList<Section> sections;

    public void setupNull() {
        sections = null;
    }

    public void setupEmpty() {
        sections = new LinkedList<>();
    }

    public void setupMissingBetween() {
        sections = new LinkedList<>();
        sections.add(new Section(1, 5));
        sections.add(new Section(11, 20));
    }

    public void setupMissingStart() {
        sections = new LinkedList<>();
        sections.add(new Section(6, 10));
        sections.add(new Section(11, 20));
    }

    public void setupMissingEnd() {
        sections = new LinkedList<>();
        sections.add(new Section(1, 5));
        sections.add(new Section(6, 10));
    }

    @Test
    public void generateSectionNullListTest() {
        setupNull();

        plane = new Plane("ID", 4, 20, sections);

        assertEquals("[[1,20]]", Arrays.toString(plane.getSections()));
    }

    @Test
    public void generateSectionEmptyListTest() {
        setupEmpty();

        plane = new Plane("ID", 4, 20, sections);

        assertEquals("[[1,20]]", Arrays.toString(plane.getSections()));
    }

    @Test
    public void generateSectionMissingBetweenTest() {
        setupMissingBetween();
        plane = new Plane("ID", 4, 20, sections);
        assertEquals("[[1,5], [6,10], [11,20]]", Arrays.toString(plane.getSections()));
    }

    @Test
    public void generateSectionMissingStartTest() {
        setupMissingStart();
        plane = new Plane("ID", 4, 20, sections);
        assertEquals("[[1,5], [6,10], [11,20]]", Arrays.toString(plane.getSections()));
    }

    @Test
    public void generateSectionMissingEndTest() {
        setupMissingEnd();
        plane = new Plane("ID", 4, 20, sections);
        assertEquals("[[1,5], [6,10], [11,20]]", Arrays.toString(plane.getSections()));
    }
}
