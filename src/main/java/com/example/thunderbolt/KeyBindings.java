package com.example.thunderbolt;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.mojang.blaze3d.platform.InputConstants;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = ThunderboltMod.MODID, value = Dist.CLIENT)
public class KeyBindings {
    public static KeyMapping SUMMON_LIGHTNING_KEY = new KeyMapping(
            "召唤雷电 (B键)",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_B,
            "雷电模组"
    );

    @Mod.EventBusSubscriber(modid = ThunderboltMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            System.out.println("【雷电模组】按键注册成功！");
            event.register(SUMMON_LIGHTNING_KEY);
        }
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (event.getKey() == GLFW.GLFW_KEY_B && event.getAction() == GLFW.GLFW_PRESS) {
            thunderHit();
        }
        if (SUMMON_LIGHTNING_KEY.consumeClick()) {
            thunderHit();
        }
    }

    private static void thunderHit() {
        Minecraft mc = Minecraft.getInstance();

        if (mc.player == null || mc.level == null) return;

        // 获取目标位置
        HitResult hit = mc.hitResult;
        Vec3 targetPos;

        if (hit != null && hit.getType() != HitResult.Type.MISS) {
            targetPos = hit.getLocation();
        } else {
            Vec3 look = mc.player.getLookAngle();
            targetPos = mc.player.position().add(look.x * 10, look.y * 10, look.z * 10);
        }

        // 查找地面高度
        BlockPos groundPos = new BlockPos((int) targetPos.x, (int) targetPos.y, (int) targetPos.z);
        while (groundPos.getY() > mc.level.getMinBuildHeight() && mc.level.isEmptyBlock(groundPos)) {
            groundPos = groundPos.below();
        }
        double spawnY = groundPos.getY() + 2;
        Vec3 spawnPos = new Vec3(targetPos.x, spawnY, targetPos.z);

        // 构建命令
        String command = String.format("summon minecraft:lightning_bolt %.2f %.2f %.2f",
                spawnPos.x, spawnPos.y, spawnPos.z);

        System.out.println("【雷电模组】发送命令: " + command);

        // ===== 直接发送命令的几种方式 =====
        try {
            // 方法1：sendCommand (最常用)
            //mc.player.connection.sendCommand(command);

            // 或者方法2：commandUnsigned (Forge)
             //CommandSigningContext context = CommandSigningContext.unsigned();
             mc.player.commandUnsigned(command);

            // 或者方法3：chatSigned
            // mc.player.connection.chatSigned("/" + command, null);

            System.out.println("【雷电模组】命令已发送");
        } catch (Exception e) {
            System.out.println("【雷电模组】发送失败: " + e.getMessage());
        }

        // 放置金块标记
        /*mc.level.setBlock(
                new BlockPos((int) spawnPos.x, (int) spawnPos.y - 1, (int) spawnPos.z),
                Blocks.GOLD_BLOCK.defaultBlockState(),
                3
        );*/

        mc.player.displayClientMessage(
                Component.literal("§e? 雷电已召唤！ ?§e"),
                true
        );
    }
}