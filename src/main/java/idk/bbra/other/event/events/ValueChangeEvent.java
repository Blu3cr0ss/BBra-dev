package idk.bbra.other.event.events;

import idk.bbra.other.event.EventStage;
import idk.earth.phobos.features.setting.Setting;

public class ValueChangeEvent
        extends EventStage {
    public Setting setting;
    public Object value;

    public ValueChangeEvent(Setting setting, Object value) {
        this.setting = setting;
        this.value = value;
    }
}

