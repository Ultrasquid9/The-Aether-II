package com.gildedgames.aether.common.world.aether.island.gen;

import com.gildedgames.aether.api.util.OpenSimplexNoise;
import com.gildedgames.aether.api.world.islands.IIslandChunkColumnInfo;
import com.gildedgames.aether.api.world.noise.IChunkNoiseBuffer2D;
import com.gildedgames.aether.common.world.aether.chunk.ChunkDataGenerator2DSingle;
import com.gildedgames.aether.common.world.aether.noise.NoiseGeneratorClouds;
import com.gildedgames.aether.common.world.aether.noise.NoiseGeneratorSoilDepth;

public abstract class AbstractIslandChunkColumnInfo implements IIslandChunkColumnInfo
{
	// Lazily initialized.
	private IChunkNoiseBuffer2D terrainDepthBuffer, cloudDepthBuffer;

	private final OpenSimplexNoise noise;

	private final int chunkX, chunkZ;

	protected AbstractIslandChunkColumnInfo(OpenSimplexNoise noise, int chunkX, int chunkZ)
	{
		this.noise = noise;

		this.chunkX = chunkX;
		this.chunkZ = chunkZ;
	}

	@Override
	public final IChunkNoiseBuffer2D getTerrainDepthBuffer()
	{
		if (this.terrainDepthBuffer == null)
		{
			this.terrainDepthBuffer = new ChunkDataGenerator2DSingle(new NoiseGeneratorSoilDepth(this.noise), 2)
					.generate(this.chunkX, this.chunkZ)
					.createInterpolatedNoiseBuffer();
		}

		return this.terrainDepthBuffer;
	}

	@Override
	public final IChunkNoiseBuffer2D getCloudDepthBuffer()
	{
		if (this.cloudDepthBuffer == null)
		{
			this.cloudDepthBuffer = new ChunkDataGenerator2DSingle(new NoiseGeneratorClouds(this.noise), 2)
					.generate(this.chunkX, this.chunkZ)
					.createInterpolatedNoiseBuffer();
		}

		return this.cloudDepthBuffer;
	}
}
