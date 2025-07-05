package dev.keesmand.magnetcommand.util;

import dev.keesmand.magnetcommand.MagnetCommandMod;
import dev.keesmand.magnetcommand.enums.MagnetMode;
import eu.pb4.playerdata.api.PlayerDataApi;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;

public class MagnetModeData {
    public static int setMagnetMode(ServerPlayerEntity player, MagnetMode mode) {
        int modeInt = mode.ordinal();
        NbtCompound nbt = PlayerDataApi.getCustomDataFor(player, MagnetCommandMod.DATA_STORAGE);
        if (nbt == null) nbt = new NbtCompound();
        nbt.putInt("mode", modeInt);
        PlayerDataApi.setCustomDataFor(player, MagnetCommandMod.DATA_STORAGE, nbt);
        return modeInt;
    }

    public static MagnetMode getMagnetMode(ServerPlayerEntity player) {
        NbtCompound nbt = PlayerDataApi.getCustomDataFor(player, MagnetCommandMod.DATA_STORAGE);
        if (nbt == null) return MagnetMode.Off;

        int modeInt = nbt.getInt("mode", 0);
        return MagnetMode.values()[modeInt];
    }
}
