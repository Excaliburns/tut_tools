package com.tut.tuttools.setup;

import net.minecraft.world.World;

public class ServerProxy implements  IProxy{

    @Override
    public World getClientWorld() {
        throw new IllegalStateException("You cannot run this code on a server!");
    }
}
