package fr.oceanquest.chunkhooper.data;

import com.bgsoftware.superiorskyblock.api.wrappers.SuperiorPlayer;
import java.util.UUID;

public class ChunkHooper {

    private SuperiorPlayer owner;
    private UUID island_id;

    public ChunkHooper(SuperiorPlayer owner, UUID island_id) {
        this.owner = owner;
        this.island_id = island_id;
    }

    public SuperiorPlayer getOwner() {
        return owner;
    }

    public UUID getIsland_id() {
        return island_id;
    }


}
