package com.example.latte_ecs.icon;

import com.joanzapata.iconify.Icon;

public enum EcIcons implements Icon {
    icon_scon('\ue606'),
    icon_alo_pay('\ue606');

    private char character;


    EcIcons(char character){
        this.character = character;

    }

    @Override
    public String key() {
        return null;
    }

    @Override
    public char character() {
        return 0;
    }
}
