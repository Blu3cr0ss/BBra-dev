package idk.bbra.other.event.events;

import idk.bbra.other.event.EventStage;
import net.minecraft.util.math.BlockPos;

public class BlockBreakingEvent
        extends EventStage {
    public BlockPos pos;

    public BlockBreakingEvent(BlockPos pos) {
        this.pos = pos;
    }
}

