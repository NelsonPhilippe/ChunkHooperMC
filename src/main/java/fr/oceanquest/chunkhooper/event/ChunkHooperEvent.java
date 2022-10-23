package fr.oceanquest.chunkhooper.event;

import fr.oceanquest.chunkhooper.data.ChunkHooper;
import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

import java.util.Map;

public class ChunkHooperEvent implements Listener {

    @EventHandler
    public void onItemDropped(ItemSpawnEvent e){

        Chunk location = e.getLocation().getChunk();

        int x = location.getX();
        int z = location.getZ();

        for(ChunkHooper chunkHoopers : fr.oceanquest.chunkhooper.ChunkHooper.chunkHooperMap.values()){

            if(x == chunkHoopers.getX() && chunkHoopers.getZ() == z){

            }

        }

    }

}
