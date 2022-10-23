package fr.oceanquest.chunkhooper.data;

import com.bgsoftware.superiorskyblock.api.wrappers.SuperiorPlayer;
import org.bukkit.Chunk;

import java.util.UUID;

public class ChunkHooper {

    private SuperiorPlayer owner;
    private UUID island_id;

    private int x;
    private int z;

    public ChunkHooper(SuperiorPlayer owner, UUID island_id, int x, int z) {
        this.owner = owner;
        this.island_id = island_id;
        this.x = x;
        this.z = z;
    }

    public SuperiorPlayer getOwner() {
        return owner;
    }

    public UUID getIsland_id() {
        return island_id;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }
}
