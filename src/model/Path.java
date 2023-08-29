package model;

public class Path<T extends INode> {
    public final T src;
    public final T dest;

    public Path(T src, T dest) {
        this.src = src;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "Path [src=" + src + ", dest=" + dest + "]";
    }
}
