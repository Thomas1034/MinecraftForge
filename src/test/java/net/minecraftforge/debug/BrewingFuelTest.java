package net.minecraftforge.debug;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.BrewingFuelRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(BrewingFuelTest.MOD_ID)
@Mod.EventBusSubscriber(modid = BrewingFuelTest.MOD_ID)
public class BrewingFuelTest {
    static final String MOD_ID = "brewing_fuel_test";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    private static final RegistryObject<Item> TEST_BREWING_FUEL = ITEMS.register("test_brewing_fuel",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    private static final boolean ENABLED = true;

    public BrewingFuelTest() {
        if (ENABLED) {
            final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            ITEMS.register(modEventBus);

            // Register the commonSetup method for modloading
            modEventBus.addListener(this::commonSetup);

        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        BrewingFuelRegistry.add(Items.BLAZE_ROD, 40);
        BrewingFuelRegistry.add(TEST_BREWING_FUEL.get(), 10);
        BrewingFuelRegistry.add(Items.COAL, 5);
    }
}
