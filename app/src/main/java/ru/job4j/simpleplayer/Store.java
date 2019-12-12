package ru.job4j.simpleplayer;

import java.util.List;

public interface Store {

    List<SoundResource> getSoundResources();

    void setSoundResources(List<SoundResource> soundResources);

    int getIdByName(String name);

    List<String> getNames();
}
