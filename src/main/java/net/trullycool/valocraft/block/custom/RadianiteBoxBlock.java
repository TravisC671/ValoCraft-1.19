package net.trullycool.valocraft.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelSet;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RadianiteBoxBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty MODEL_INDEX = IntProperty.of("model_index", 0, 13);

    public RadianiteBoxBlock(Settings settings) {
        super(settings);
    }

    private static VoxelShape NORTH_SHAPE = Block.createCuboidShape(0,0,0,16, 32, 16);
    private static VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0,0,0,16, 32, 16);
    private static VoxelShape WEST_SHAPE = Block.createCuboidShape(0,0,0,16, 32, 16);
    private static VoxelShape EAST_SHAPE = Block.createCuboidShape(0,0,0,16, 32, 16);

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient() && hand == Hand.MAIN_HAND && player.isCreative()) {
            world.setBlockState(pos, state.cycle(MODEL_INDEX));
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        /*
        Direction direction = state.get(FACING);
        switch (direction) {
            case NORTH: {
                return NORTH_SHAPE;
            }
            case SOUTH: {
                return SOUTH_SHAPE;
            }
            case WEST: {
                return WEST_SHAPE;
            }
        }
        return EAST_SHAPE;*/
        Integer modelIndex = state.get(MODEL_INDEX);

        switch (modelIndex) {
            //full
            case 0, 1, 2, 3 -> {
                return Block.createCuboidShape(0, 0, 0, 16, 32, 16);
            }

            //half_side
            case 4, 5 -> {
                return Block.createCuboidShape(0, 0, 8, 16, 32, 16);
            }

            case 6, 7 -> {
                return Block.createCuboidShape(0, 0, 0, 8, 32, 16);
            }

            //half_top
            case 8, 9 -> {
                return Block.createCuboidShape(-16, 0, 0, 16, 8, 16);
            }

            //quarter_top
            case 10 -> {
                return Block.createCuboidShape(-16, 0, 8, 16, 8, 16);
            }

            case 11 -> {
                return Block.createCuboidShape(0, 0, -16, 8, 8, 16);
            }

            //quarter_side
            case 12 -> {
                return Block.createCuboidShape(0, 0, 8, 8, 32, 16);
            }
        }
        return Block.createCuboidShape(0,0,8,8, 8, 16);

    }
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(MODEL_INDEX);
    }
}
