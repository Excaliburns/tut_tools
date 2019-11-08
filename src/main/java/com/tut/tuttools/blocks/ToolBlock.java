package com.tut.tuttools.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.command.impl.SummonCommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ToolBlock extends Block {

    public ToolBlock() {
        super(Properties.create(Material.CLAY)
                .sound(SoundType.SLIME)
                .hardnessAndResistance(2.0f)
                .lightValue(12)
        );

        setRegistryName("toolblock");
    }

    @Override
    public void onLanded(IBlockReader worldIn, Entity entityIn) {
        if (entityIn.isSneaking()) {
            super.onLanded(worldIn, entityIn);
        } else {
            Vec3d vec3d = entityIn.getMotion();
            if (vec3d.y < 0.0D) {
                double d0 = entityIn instanceof LivingEntity ? 1.0D : 0.8D;
                entityIn.setMotion(vec3d.x, vec3d.y + d0, vec3d.z);
            }

            World world = entityIn.getEntityWorld();

            System.out.println(entityIn.getEntity().getPosition());

            if(entityIn.getEntity() instanceof PlayerEntity)
            {
                BlockPos blockPos = entityIn.getPosition();

                CowEntity cowEntity = new CowEntity(EntityType.COW, world);
                cowEntity.setPosition(blockPos.getX(), blockPos.getY(), blockPos.getZ());

                for(int i = 0; i < 2; i++) {
                    world.addEntity(cowEntity);
                    System.out.println("cow spawning xd - " + cowEntity.getPosition());
                }
            }
        }
    }
}
