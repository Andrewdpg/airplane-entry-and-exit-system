package entity;

import java.util.List;

public class Plane {
    
    public static final String PATH = "data/plane/";

    String id;
    int columns;
    int rows;
    Section[] sections;

    public Plane(String id, int columns, int rows, List<Section> sections) {
        this.id = id;
        this.columns = columns;
        this.rows = rows;
        generateSections(sections);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Section[] getSections() {
        return sections;
    }

    public void setSections(Section[] sections) {
        this.sections = sections;
    }

    public void generateSections(List<Section> list) {
        if (list == null) {
            sections = new Section[] {
                    new Section(1, rows)
            };
            return;
        }
        if (list.size() == 0) {
            sections = new Section[] {
                    new Section(1, rows)
            };
            return;
        }
        list.sort(null);
        int index = 0;
        Section current = list.get(0);
        for (int i = 1; i <= rows; i++) {
            if (i < current.getStart()) {
                list.add(index, new Section(i, current.getStart() - 1));
                i = current.getStart();
                index++;
            }
            if (i == current.getEnd() && i != rows) {
                index++;
                if (index < list.size()) {
                    current = list.get(index);
                } else {
                    list.add(new Section(i + 1, rows));
                }
            }
        }
        sections = new Section[list.size()];
        for (int i = 0; i < sections.length; i++) {
            sections[i] = list.get(i);
        }
    }
}
