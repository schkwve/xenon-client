package me.rj45.xenonclient.module;

import me.rj45.xenonclient.module.movement.Flight;
import me.rj45.xenonclient.module.movement.Sprint;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();
    private List<XenonModule> modules = new ArrayList<>();

    public ModuleManager() {
        addModules();
    }

    public List<XenonModule> getModules() {
        return modules;
    }

    public List<XenonModule> getEnabledModules() {
        List<XenonModule> enabled = new ArrayList<>();
        for (XenonModule module : modules) {
            if (module.isEnabled()) {
                enabled.add(module);
            }
        }

        return enabled;
    }

    private void addModules() {
        modules.add(new Flight());
        modules.add(new Sprint());
    }
}
