package model;

public class Path {
    private final int src;
    private final int dest;

    public Path(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + src;
        result = prime * result + dest;
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
        Path other = (Path) obj;
        if (src != other.src)
            return false;
        if (dest != other.dest)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Path [src=" + src + ", dest=" + dest + "]";
    }
}
