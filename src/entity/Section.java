package entity;

public class Section implements Comparable<Section> {

    private int start;
    private int end;

    public Section(int start, int end) {
        this.start = Integer.min(start, end);
        this.end = Integer.max(start, end);
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int compareTo(Section o) {
        return start - o.getStart();
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}
