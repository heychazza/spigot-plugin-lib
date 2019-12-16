package io.felux.lib.api.item;

import de.tr7zw.changeme.nbtapi.NBTItem;
import io.felux.lib.api.exception.InvalidEnchantException;
import io.felux.lib.api.exception.InvalidFlagException;
import io.felux.lib.api.exception.InvalidMaterialException;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class ItemUtil {

    static Material getMaterial(String material) throws InvalidMaterialException {
        material = material.toUpperCase();
        Material materialObj = Material.getMaterial(material);
        if (materialObj == null) {
            throw new InvalidMaterialException(material);
        }
        return materialObj;
    }

    public static ItemFlag getFlag(String flag) throws InvalidFlagException {
        flag = flag.toUpperCase();
        ItemFlag itemFlag = null;
        for (ItemFlag e : ItemFlag.values()) {
            if (e.name().equalsIgnoreCase(flag)) {
                itemFlag = e;
                break;
            }
        }

        if (itemFlag == null) {
            throw new InvalidFlagException(flag);
        }

        return itemFlag;
    }

    @SuppressWarnings("deprecation")
    public static Enchantment getEnchantment(String enchant) throws InvalidEnchantException {
        enchant = enchant.toUpperCase();

        Enchantment enchantment = null;
        for (Enchantment e : Enchantment.values()) {
            if (e.getName().equalsIgnoreCase(enchant)) {
                enchantment = e;
                break;
            }
        }

        if (enchantment == null) throw new InvalidEnchantException(enchant);
        return enchantment;
    }

    public static String getNBTString(ItemStack item, String key) {
        NBTItem nbtItem = new NBTItem(item);
        if (nbtItem.hasNBTData() && nbtItem.hasKey(key)) return nbtItem.getString(key);
        return null;
    }
}
