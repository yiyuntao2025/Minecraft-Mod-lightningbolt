package com.example.thunderbolt;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ThunderboltMod.MODID)
public class ThunderboltMod {
    public static final String MODID = "thunderbolt";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ThunderboltMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
        
        LOGGER.info("Thunderbolt Mod 加载成功！");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Thunderbolt Mod 客户端初始化完成！按 B 键召唤闪电");
    }
}