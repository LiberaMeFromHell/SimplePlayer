package ru.job4j.simpleplayer;

public class SoundResource {

    private int resId;
    private String name;

    public SoundResource(int resId, String name) {
        this.resId = resId;
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoundResource)) return false;

        SoundResource that = (SoundResource) o;

        if (getResId() != that.getResId()) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getResId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
