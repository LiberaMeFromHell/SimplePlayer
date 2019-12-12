package ru.job4j.simpleplayer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SoundStore implements Store {

    private List<SoundResource> soundResources = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    public SoundStore() {
        getRawResources();
        initNames();
    }

    private void getRawResources() {

        Field[] fields = R.raw.class.getFields();

        for (int i = 0; i < fields.length; i++) {

            String name = fields[i].getName();
            int rawId = 0;

            try {
                rawId = fields[i].getInt(fields[i]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            soundResources.add(new SoundResource(rawId, name));
        }
    }

    private void initNames() {

        for (SoundResource res :
                soundResources) {
            names.add(res.getName());
        }
    }

    public List<SoundResource> getSoundResources() {
        return soundResources;
    }

    public void setSoundResources(List<SoundResource> soundResources) {
        this.soundResources = soundResources;
    }

    @Override
    public int getIdByName(String name) {

        int id = 0;

        for (SoundResource soundResource :
                soundResources) {
            if (name.equals(soundResource.getName())) {
                id = soundResource.getResId();
            }
        }

        return id;
    }

    @Override
    public List<String> getNames() {
        return names;
    }
}
